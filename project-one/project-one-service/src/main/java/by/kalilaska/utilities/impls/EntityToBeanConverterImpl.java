package by.kalilaska.utilities.impls;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.kalilaska.utilities.EntityToBeanConverter;

@Service
public class EntityToBeanConverterImpl implements EntityToBeanConverter{

	@Autowired
	private Mapper dozerMapper;

	@Override
	public <E, B> B convertToBean(E entity, Class<B> beanClass) {
		B bean = dozerMapper.map(entity, beanClass);

		return bean;
	}

	@Override
	public <E, B> List<B> convertToBeanList(List<E> entitiesList, Class<B> beanClass) {
		List<B> beansList = new ArrayList<>();

		for (E entity : entitiesList) {
			B bean = convertToBean(entity, beanClass);
			beansList.add(bean);
		}

		return beansList;
	}

	@Override
	public <E, B> E convertToEntity(B bean, Class<E> entityClass) {
		E entity = dozerMapper.map(bean, entityClass);

		return entity;
	}
}
