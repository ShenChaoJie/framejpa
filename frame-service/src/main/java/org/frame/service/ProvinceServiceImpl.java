package org.frame.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.frame.common.page.PageBar;
import org.frame.common.utils.MyUtil;
import org.frame.persistence.po.TProvince;
import org.frame.service.api.ProvinceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProvinceServiceImpl extends BaseService implements ProvinceService {
	
	@Transactional(rollbackFor=Exception.class) 
	public Map<String, String> addProvince(Map<String, String> para) throws Exception {
		Map<String, String> rmap = new HashMap<String, String>();
		MyUtil mu = MyUtil.getInstance();
		TProvince province = new TProvince();
		mu.map2Object(para, province);
		//List provinceList = this.getBaseDao().findList("from TProvince where name = ?",new Object[] { para.get("name") });
		List provinceList = this.getProvinceDao().findByName(para.get("name"));
		if (provinceList.size() > 0) {
			rmap.put("info", "isUse");
		} else {
			this.getProvinceDao().save(province);
			rmap.put("info", "ok");
		}
		return rmap;
	}

	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor=Exception.class) 
	public Map<String, String> delProvince(Map<String, String> para) throws Exception {
		Map<String, String> rmap = new HashMap<String, String>();
		//TProvince province = (TProvince) this.getBaseDao().findObject("from TProvince where id = ?",new Object[] { Integer.parseInt(para.get("id")) });
		
		TProvince province = (TProvince) this.getProvinceDao().getOne(Integer.parseInt(para.get("id")));
		
		if (0 == province.getPid()) {
			//List subList = this.getBaseDao().findList("from TProvince where pid = ?",new Object[] { Integer.parseInt(para.get("id")) });
			
			List<TProvince> subList = this.getProvinceDao().findByPid(Integer.parseInt(para.get("id")));
			if (subList.size() > 0) {
				rmap.put("info", "isUse");
			} else {
				this.getProvinceDao().delete(province);
			}
		} else {
			this.getProvinceDao().delete(province);
		}
		rmap.put("info", "ok");
		return rmap;
	}

	@Transactional(readOnly=true)
	@SuppressWarnings("rawtypes")
	public List queryProvince() throws Exception {
		//List provinceList = this.getBaseDao().findList("from TProvince where pid = 0", null);
		List provinceList = this.getProvinceDao().findByPid(0);
		return provinceList;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public TProvince getProvince(Map<String, String> para) throws Exception {
		return (TProvince) this.getProvinceDao().getOne(Integer.parseInt(para.get("id")));
		//return (TProvince) this.getBaseDao().findObject("from TProvince where id = ?",new Object[] { Integer.parseInt(para.get("id")) });
	}

	@Transactional(readOnly=true)
	public PageBar queryProvince(Map<String, String> para) throws Exception {
		PageBar pb = new PageBar(para);
		
		//List<Object> plist = new ArrayList<Object>();
		//StringBuilder hsql = new StringBuilder("from TProvince a where a.pid = 0");
		//pb.setTotalNum(this.getBaseDao().findInt(" select count(a.id) " + hsql, plist.toArray()));
		//pb.setTotalNum(this.getProvinceDao().countBySql("select count(a.id) from t_province a where a.pid = 0"));
		
		/*if (pb.getTotalNum() == 0)
			return pb;*/
		//List<Map<String, Object>> rList = this.getProvinceDao().findByJpql(hsql + " order by a.id asc ", plist.toArray(),pb);
		
		//List<Map<String, Object>> rList = this.getProvinceDao().findByJpql(hsql + " order by a.id asc ", null);
		
		//List<Map<String, Object>> rList = this.getProvinceDao().findBySql("select * from t_province a where a.pid=0");
		
		//pb.setResultList(rList);
		
		
		/*Pageable pageable = new PageRequest(Integer.parseInt(para.get("currentPageNum")), Integer.parseInt(para.get("everyPageNum")),new Sort(Direction.ASC, "id") );
		
		StringBuilder jpql = new StringBuilder("from t_province a where a.pid = 0");
		
		@SuppressWarnings("rawtypes")
		Page page =this.getProvinceDao().findByJpql(jpql + " order by a.id asc ", new HashMap(), pageable);
		*/
		pb.setTotalNum(this.getProvinceDao().count());
		
		Pageable pageable = new PageRequest((int)pb.getCurrentPageNum(), (int)pb.getEveryPageNum());
		Page<TProvince> provincePage = this.getProvinceDao().findAll(pageable);
		List<TProvince> rList = provincePage.getContent();
		
		pb.setResultList(rList);
		return pb;
	}

	/**
	 * 
	 * 功能：查询地�?
	 * 
	 * @author zjy
	 * @param para
	 * @return
	 * @throws Exception
	 * @throws Exception
	 */
	public PageBar queryCity(Map<String, String> para) throws Exception {
		/*PageBar pb = new PageBar(para);
		MyUtil mu = MyUtil.getInstance();
		List<Object> plist = new ArrayList<Object>();
		String sql = "SELECT count(t2.id) FROM t_province t1, t_province t2 WHERE t1.id = t2.pid ";
		pb.setTotalNum(this.getBaseDao().findIntBySql(sql, plist.toArray()));
		if (pb.getTotalNum() == 0)
			return pb;
		sql = "SELECT {t2.*}, {t1.*} FROM t_province t1, t_province t2 WHERE t1.id = t2.pid";
		Map<String, Class> entities = new HashMap<String, Class>();
		entities.put("t1", TProvince.class);
		entities.put("t2", TProvince.class);
		List rList = this.getBaseDao().findListMapWithEntityPageBySql(sql, plist.toArray(), pb, entities);
		pb.setResultList(rList);
		return pb;*/
		return null;
	}

	public PageBar queryProvinceDetail(Map<String, String> para) throws Exception {
		PageBar pb = new PageBar(para);
		MyUtil mu = MyUtil.getInstance();
		
		//List<Object> plist = new ArrayList<Object>();
		//plist.add(Integer.parseInt(para.get("pid")));
		//pb.setTotalNum(this.getBaseDao().findInt(" select count(a.id) " + hsql, plist.toArray()));
		
		/*StringBuilder hsql = new StringBuilder("from TProvince a where a.pid = ?");
		Map<String,Object> maps = new HashMap<String, Object>();
		maps.put("pid", Integer.parseInt(para.get("pid")));
		pb.setTotalNum(this.getProvinceDao().countByJpql("select count(a.id) " + hsql,maps));
		
		if (pb.getTotalNum() == 0)
			return pb;
		List<Map<String, Object>> rList = this.getBaseDao().findListPage(hsql + " order by a.id asc ", plist.toArray(),pb);
		
		pb.setResultList(rList);*/
		return pb;
	}

	public Map<String, String> upProvince(Map<String, String> para) throws Exception {
		Map<String, String> rmap = new HashMap<String, String>();
		MyUtil mu = MyUtil.getInstance();
		TProvince province = new TProvince();
		mu.map2Object(para, province);
		//List provinceList = this.getBaseDao().findList("from TProvince where id != ? and pid = ? and name = ?",new Object[] { Integer.parseInt(para.get("id")), Integer.parseInt(para.get("pid")), para.get("name") });
		
		Map<String,Object> maps = new HashMap<String, Object>();
		maps.put("id", Integer.parseInt(para.get("id")));
		maps.put("pid", Integer.parseInt(para.get("pid")));
		maps.put("name", para.get("name"));
		//List provinceList = this.getProvinceDao().findByJpql("from TProvince where id != ? and pid = ? and name = ?", maps);
		
		/*if (provinceList.size() > 0) {
			rmap.put("info", "isUse");
		} else {
			this.getProvinceDao().save(province);
			rmap.put("info", "ok");
		}*/
		return rmap;
	}

	public PageBar queryProvinceForChoose(Map<String, String> para) throws Exception {
		para.put("everyPageNum", "40");
		PageBar pb = new PageBar(para);
		MyUtil mu = MyUtil.getInstance();
		//List<Object> plist = new ArrayList<Object>();
		StringBuilder hsql = new StringBuilder("from TProvince a where a.pid = 0");
		//pb.setTotalNum(this.getBaseDao().findInt(" select count(a.id) " + hsql, plist.toArray()));
		
		//pb.setTotalNum(this.getProvinceDao().countByJpql(" select count(a.id) " + hsql));
		
		if (pb.getTotalNum() == 0)
			return pb;
		//List<Map<String, Object>> rList = this.getBaseDao().findListPage(hsql + " order by a.id asc ", plist.toArray(),pb);
		
		//List<Map<String, Object>> rList = this.getProvinceDao().findByJpql(hsql + " order by a.id asc ", null);
		
		//pb.setResultList(rList);
		return pb;
	}

	public TProvince findById(Integer id) {
		//return (TProvince)this.getBaseDao().findObject("from TProvince a where id = ?", new Object[]{id});
		return (TProvince) this.getProvinceDao().getOne(id);
	}

	public List<TProvince> findByPid(Integer pid) {
		//return (List<TProvince>)this.getBaseDao().findList("from TProvince a where pid = ?", new Object[]{pid});
		return this.getProvinceDao().findByPid(pid);
	}

	@Override
	public List<TProvince> getProvinceAndCity() {
		//return (List<TProvince>)this.getBaseDao().findList("from TProvince a", null);
		return this.getProvinceDao().findAll();
	}
	
	public List<TProvince> findByIds(String ids) throws Exception {
		//return (List<TProvince>)this.getBaseDao().findList("from TProvince a where id in ("+ids+")",null);
		//return (List<TProvince>)this.getProvinceDao().findByJpql("from TProvince a where id in ("+ids+")", null);
		return null;
	}
	
}
