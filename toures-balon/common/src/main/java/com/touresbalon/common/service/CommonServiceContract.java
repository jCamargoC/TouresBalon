package com.touresbalon.common.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.touresbalon.common.BusinessException;
import com.touresbalon.common.ErrorsEnum;
import com.touresbalon.common.spring.conf.hibernate.IBaseRepository;
@Transactional("transactionManagerJPA")
public abstract class CommonServiceContract<T extends Object> {

	@Autowired
	protected IBaseRepository<T, Long> repository;

	public T saveObject(T object) {
		if (validate(object)) {
			object = repository.save(object);
			return postSave(object);
		}
		return null;
	}

	public abstract T postSave(T object);

	public abstract Boolean validate(T object);

	public boolean delete(Long id) {
		T object = repository.getOne(id);
		if (object != null) {
			boolean associated = deleteAssociatedObjects(object);
			if (associated) {
				repository.delete(object);
				return Boolean.TRUE;
			}
			return Boolean.FALSE;
		}
		throw new BusinessException(ErrorsEnum.OBJECT_DOES_NOT_EXISTS);

	}

	public abstract boolean deleteAssociatedObjects(T object);

	public T findOne(Long id) {
		Optional<T> opt = repository.findById(id);
		if (opt.isPresent()) {
			T obj = opt.get();
			return obj;
		}
		throw new BusinessException(ErrorsEnum.OBJECT_DOES_NOT_EXISTS);

	}

	public List<T> findAll() {
		return repository.findAll();
	}

	public T findByAttribute(String attribute, Object value) {
		String capitalizedAttr = capitalize(attribute);
		String methodName = "findBy" + capitalizedAttr;
		try {
			Method method = repository.getClass().getMethod(methodName, value.getClass());
			T response = (T) method.invoke(repository, value);
			return response;
		} catch (NoSuchMethodException e) {
			throw new BusinessException(ErrorsEnum.REFLECTION_ERROR);
		} catch (SecurityException e) {
			throw new BusinessException(ErrorsEnum.REFLECTION_ERROR);
		} catch (IllegalAccessException e) {
			throw new BusinessException(ErrorsEnum.REFLECTION_ERROR);
		} catch (IllegalArgumentException e) {
			throw new BusinessException(ErrorsEnum.REFLECTION_ERROR);
		} catch (InvocationTargetException e) {
			throw new BusinessException(ErrorsEnum.REFLECTION_ERROR);
		}
	}
	
	public List<T> findByAttributeList(String attribute, Object value) {
		String capitalizedAttr = capitalize(attribute);
		String methodName = "findBy" + capitalizedAttr;
		try {
			Method method = repository.getClass().getMethod(methodName, value.getClass());
			List<T> response = (List<T>) method.invoke(repository, value);
			return response;
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new BusinessException(ErrorsEnum.REFLECTION_ERROR);
		} catch (SecurityException e) {
			e.printStackTrace();
			throw new BusinessException(ErrorsEnum.REFLECTION_ERROR);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new BusinessException(ErrorsEnum.REFLECTION_ERROR);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new BusinessException(ErrorsEnum.REFLECTION_ERROR);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new BusinessException(ErrorsEnum.REFLECTION_ERROR);
		}
	}

	private String capitalize(String string) {
		return Character.toUpperCase(string.charAt(0)) + string.substring(1);
	}
	
	public abstract T removeChild(T object,Long idChild);
}
