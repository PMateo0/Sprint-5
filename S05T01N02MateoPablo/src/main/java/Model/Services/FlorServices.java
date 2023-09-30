package Model.Services;

import Model.Domain.FlorEntity;
import Model.Dto.FlorDTO;
import Model.Repository.FlorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class FlorServices implements IFlorServices{

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private FlorRepository florRespository;

    @Override
    public void save(FlorDTO florDTO) {
        florRespository.save(modelMapper.map(florDTO, FlorEntity.class));
    }

    @Override
    public void update(FlorDTO florDTO) {
        FlorEntity florEntity = convertDTOToEntity(florDTO);
        florRespository.save(florEntity);

    }

    @Override
    public void delete(int id) {
        florRespository.deleteById(id);
    }

    @Override
    public FlorDTO getOne(int id) {
        Optional<FlorEntity> optionalFlor = florRespository.findById(id);
        FlorDTO florDto= null;
        if (optionalFlor.isPresent()) {
            florDto = convertEntityToDTO(optionalFlor.get());
        }
        return florDto;
    }

    @Override
    public List<FlorDTO> getAll() {
        return florRespository.findAll()
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    public FlorDTO convertEntityToDTO(FlorEntity flor) {
        return  modelMapper.map(flor, FlorDTO.class);
    }

    public FlorEntity convertDTOToEntity(FlorDTO florDTO) {
        return  modelMapper.map(florDTO, FlorEntity.class);
    }
}