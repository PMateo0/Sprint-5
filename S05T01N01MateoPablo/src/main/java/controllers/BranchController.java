package controllers;

import model.domain.Branch;
import model.dto.BranchDTO;
import model.services.BranchServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/branch")
public class BranchController {

    @Autowired
    BranchServices branchServices;



    @GetMapping("/add")
    public String addBranch(Model model) {
        Branch newBranch = new Branch();
        model.addAttribute("branch",newBranch);
        return "createBranch";
    }


    @GetMapping("/update/{id}")
    public String showAndEditBranch(@PathVariable Integer id, Model model) {
        model.addAttribute("branch", branchServices.getOne(id));
        return "updateBranch";
    }

    @PostMapping("/update/{id}")
    public String saveAndEditSBranch(@PathVariable Integer id, @ModelAttribute("branch") BranchDTO branchDTO, Model model) {
        BranchDTO actualizadaSucursalDto = branchServices.getOne(id);
        actualizadaSucursalDto.setName(branchDTO.getName());
        actualizadaSucursalDto.setCountry(branchDTO.getCountry());
        branchServices.update(actualizadaSucursalDto);
        return "redirect:/branch";
    }

    @GetMapping("/delete/{id}")
    public String deleteBranch(@PathVariable Integer id){
        branchServices.delete(id);
        return "redirect:/branch";
    }


    @GetMapping("/getOne/{id}")
    public String getBranch(@PathVariable Integer id, Model model ) {
        model.addAttribute("branch", branchServices.getOne(id));
        return "showBranch";
    }

    @GetMapping({"/getAll","/",""})
    public String getAll(Model model) {
        model.addAttribute("branchList", branchServices.getAll());
        if (branchServices.getAll().isEmpty()) {
            return HttpStatus.NO_CONTENT.toString();
        }
        return "branch";
    }
    @PostMapping ({"/getAll","/",""})
    public String saveBranch (@ModelAttribute("branch") BranchDTO branchDTO){
        branchServices.save(branchDTO);
        return "redirect:/branch";
    }

}