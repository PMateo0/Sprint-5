package model.services;

import model.domain.Branch;
import model.dto.BranchDTO;
import model.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BranchServices implements IBranchServices {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private BranchRepository branchRepository;

    @Override
    public void save(BranchDTO branchDTO) {
        branchRepository.save(modelMapper.map(branchDTO, Branch.class));
    }

    @Override
    public void update(BranchDTO branchDTO) {
        Branch sucursal = convertDTOToEntity(branchDTO);
        branchRepository.save(sucursal);
    }

    @Override
    public void delete(int id) {
        branchRepository.deleteById(id);
    }

    @Override
    public BranchDTO getOne(int id) {
        Optional<Branch> optionalSucursal = branchRepository.findById(id);
        BranchDTO sucursalDto= null;
        if (optionalSucursal.isPresent()) {
            sucursalDto = convertEntityToDTO(optionalSucursal.get());
        }
        return sucursalDto;
    }

    @Override
    public List<BranchDTO> getAll() {
        return branchRepository.findAll()
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    public BranchDTO convertEntityToDTO(Branch branch) {
        return  modelMapper.map(branch, BranchDTO.class);
    }

    public Branch convertDTOToEntity(BranchDTO sucursalDTO) {
        return  modelMapper.map(sucursalDTO, Branch.class);
    }
}