package com.zboss.fw.core.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public abstract class BaseService<T, ID extends Serializable> implements JpaRepository<T, ID>
{

	protected JpaRepository<T, ID> dao;

	protected abstract void setBaseDao(JpaRepository<T, ID> dao);

	@Override
	@Transactional(readOnly = false)
	public <S extends T> S save(S entity)
	{
		return dao.save(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public <S extends T> List<S> save(Iterable<S> entities)
	{
		return dao.save(entities);
	}

	@Override
	public T findOne(ID id)
	{
		return dao.findOne(id);
	}

	@Override
	public boolean exists(ID id)
	{
		return dao.exists(id);
	}

	@Override
	public List<T> findAll()
	{
		return dao.findAll();
	}

	@Override
	public Iterable<T> findAll(Iterable<ID> ids)
	{
		return dao.findAll(ids);
	}

	@Override
	public long count()
	{
		return dao.count();
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(ID id)
	{
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(T entity)
	{
		dao.delete(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public void delete(Iterable<? extends T> entities)
	{
		dao.delete(entities);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteAll()
	{
		dao.deleteAll();
	}

	@Override
	public List<T> findAll(Sort sort)
	{
		return dao.findAll(sort);
	}

	@Override
	public Page<T> findAll(Pageable pageable)
	{
		return dao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = false)
	public void flush()
	{
		dao.flush();
	}

	@Override
	@Transactional(readOnly = false)
	public T saveAndFlush(T entity)
	{
		return dao.saveAndFlush(entity);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteInBatch(Iterable<T> entities)
	{
		dao.deleteInBatch(entities);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteAllInBatch()
	{
		dao.deleteAllInBatch();
	}

}
