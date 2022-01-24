package gg.edor.rol.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractDao extends SqlSessionDaoSupport {

    @Autowired
    public SqlSessionTemplate sqlSessionTemplate;

    public <T> T select(String queryId) {
        return this.sqlSessionTemplate.selectOne(queryId);
    }

    public <T> T select(String queryId, Object parameterObject) {
        return this.sqlSessionTemplate.selectOne(queryId, parameterObject);
    }

    public <E> List<E> selectList(String queryId) {
        return this.sqlSessionTemplate.selectList(queryId);
    }

    public <E> List<E> selectList(String queryId, Object parameterObject) {
        return this.sqlSessionTemplate.selectList(queryId, parameterObject);
    }

    public int insert(String queryId) {
        return this.sqlSessionTemplate.insert(queryId);
    }

    public int insert(String queryId, Object parameterObject) {
        return this.sqlSessionTemplate.insert(queryId, parameterObject);
    }

    public int update(String queryId) {
        return this.sqlSessionTemplate.update(queryId);
    }

    public int update(String queryId, Object parameterObject) {
        return this.sqlSessionTemplate.update(queryId, parameterObject);
    }

    public int delete(String queryId) {
        return this.sqlSessionTemplate.delete(queryId);
    }

    public int delete(String queryId, Object parameterObject) {
        return this.sqlSessionTemplate.delete(queryId, parameterObject);
    }

    @Autowired
//    @Resource(name = "getSessionFactory")
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public <T> T selectOne(String queryId) {
        return this.getSqlSession().selectOne(queryId);
    }

    public <T> T selectOne(String queryId, Object parameterObject) {
        return this.getSqlSession().selectOne(queryId, parameterObject);
    }
}
