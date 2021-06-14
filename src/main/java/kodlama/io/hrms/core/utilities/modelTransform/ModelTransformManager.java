package kodlama.io.hrms.core.utilities.modelTransform;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.constants.Messages;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.entities.concretes.JobseekerCv;

@Service
public class ModelTransformManager implements ModelTransformService {
	private ModelMapper modelMapper;

	@Autowired
	public ModelTransformManager(ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	@Override
	public <S, D> List<D> getEntityToDtoList(List<S> sourceData, Class<D> dto) {
		return sourceData.stream().map(data -> modelMapper.map(data, dto)).collect(Collectors.toList());

	}


	@Override
	public <D> Object postEntityToDto(Object sourceDto,Class<D>targetClass) {
		return modelMapper.map(sourceDto, targetClass);
		
	}

	@Override
	public <S, D> D getEntityToDto(S sourceData, Class<D> dto) {
		return modelMapper.map(sourceData, dto);
	}
}