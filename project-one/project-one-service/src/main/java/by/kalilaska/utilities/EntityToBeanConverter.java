package by.kalilaska.utilities;

import java.util.List;

public interface EntityToBeanConverter {
	
	public <E, B> B convertToBean(E entity, Class<B> beanClass);
	
	public <E, B> List<B> convertToBeanList(List<E> entitiesList, Class<B> beanClass);
	
	public <E, B> E convertToEntity(B bean, Class<E> entityClass);

}
