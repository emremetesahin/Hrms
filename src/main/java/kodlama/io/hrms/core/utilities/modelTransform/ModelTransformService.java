package kodlama.io.hrms.core.utilities.modelTransform;

import java.util.List;

public interface ModelTransformService {
	<S,D> List<D> getEntityToDto (List<S> sourceData,Class<D> dto);
	<T> Object postEntityToDto(Object sourceDto,Class<T> targetClass);
}
	