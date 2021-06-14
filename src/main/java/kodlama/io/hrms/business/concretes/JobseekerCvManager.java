package kodlama.io.hrms.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobseekerCvService;
import kodlama.io.hrms.business.constants.Messages;
import kodlama.io.hrms.core.utilities.modelTransform.ModelTransformService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobseekerCvDao;
import kodlama.io.hrms.entities.concretes.JobseekerCv;
import kodlama.io.hrms.entities.concretes.User;
import kodlama.io.hrms.entities.concretes.dtos.JobseekerCvAddDto;
import kodlama.io.hrms.entities.concretes.dtos.JobseekerCvDetailsDto;
@Service
public class JobseekerCvManager implements JobseekerCvService {
	private JobseekerCvDao jobseekerCvDao;
	private ModelTransformService modelTransformService;

	@Autowired
	public JobseekerCvManager(JobseekerCvDao jobseekerCvDao,ModelTransformService modelTransformService) {
		this.jobseekerCvDao = jobseekerCvDao;
		this.modelTransformService=modelTransformService;
	}

	@Override
	public Result add(JobseekerCvAddDto jobseekerCvAddDto) {
		this.jobseekerCvDao.save((JobseekerCv) modelTransformService.postEntityToDto(jobseekerCvAddDto,JobseekerCv.class));
		return new SuccessResult(Messages.dataAdded);

	}

	@Override
	public DataResult<List<JobseekerCv>> getAll() {
		return new SuccessDataResult<List<JobseekerCv>>(jobseekerCvDao.findAll(),Messages.DataListed);
	}

	@Override
	public DataResult<List<JobseekerCvDetailsDto>> getCvDetails(){
		var cvs=this.jobseekerCvDao.findAll();
	return new SuccessDataResult<List<JobseekerCvDetailsDto>>(this.modelTransformService.getEntityToDtoList(cvs,JobseekerCvDetailsDto.class),Messages.DataListed);
		
	}

	@Override
	public DataResult<List<JobseekerCvDetailsDto>> getByJobseekerId(int jobseekerId) {
		var cvs=this.jobseekerCvDao.getByJobseekerUserId(jobseekerId);
		return new SuccessDataResult<List<JobseekerCvDetailsDto>>(this.modelTransformService.getEntityToDtoList(cvs,JobseekerCvDetailsDto.class),Messages.DataListed);
	}

	@Override
	public DataResult<JobseekerCvDetailsDto> getById(int cvId) {
		var cv=this.jobseekerCvDao.getById(cvId);
		return new SuccessDataResult<JobseekerCvDetailsDto>(this.modelTransformService.getEntityToDto(cv,JobseekerCvDetailsDto.class),Messages.DataListed);
	}

}
