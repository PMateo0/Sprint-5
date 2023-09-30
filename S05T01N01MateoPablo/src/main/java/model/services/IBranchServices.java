package model.services;

import model.dto.BranchDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBranchServices {



    void  save (BranchDTO branchDTO);
    void update ( BranchDTO branchDTO);
    void delete (int id);
    BranchDTO getOne (int id);
    List<BranchDTO> getAll ();
}
