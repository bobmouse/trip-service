package go.tripservice.server.model.dao;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * User: bobmouse
 * Date: 03.02.12
 * Time: 16:48
 */
public abstract class GenericDAO<ID extends Serializable, ENTITY> {
    private HibernateTemplate hibernateTemplate;
    private Class<ENTITY> persistentClass;

    @SuppressWarnings("unchecked")
    protected GenericDAO() {
        persistentClass = (Class<ENTITY>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Transactional
    public void save(ENTITY entity){
        hibernateTemplate.save(entity);
    }

    public ENTITY get(ID id){
        return hibernateTemplate.get(persistentClass, id);
    }

    public List<ENTITY> loadAll(){
        return hibernateTemplate.loadAll(persistentClass);
    }
}
