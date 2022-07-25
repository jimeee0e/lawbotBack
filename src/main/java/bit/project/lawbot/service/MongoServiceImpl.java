package bit.project.lawbot.service;

import bit.project.lawbot.domain.TestDTO;
import org.apache.ibatis.io.ResolverUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MongoServiceImpl implements MongoService {

	@Autowired
	private MongoTemplate template;

	public int haha() {
		System.out.println("크하하하");
		Criteria criteria = new Criteria("_id");
		criteria.is("62b10967bf47014238bc59c0");

		Query query = new Query(criteria);

		System.out.println("템플릿"+template);
		TestDTO dto = template.findOne(query, TestDTO.class, "test");
		System.out.println(dto);

		return 0;
	}

	public int test1(){
		System.out.println();
		Criteria criteria = new Criteria("_id");
		criteria.is("62b10967bf47014238bc59c0");
		Query query = new Query(criteria);
		System.out.println("존재하는가"+template.exists(query,TestDTO.class));
		return 0;
	}

	@Override
	public int test2() {
		Criteria criteria = new Criteria("_id");
		criteria.is("62b10967bf47014238bc59c0");
		Query query = new Query(criteria);
		System.out.println("개수"+template.count(query,TestDTO.class));
		return 0;
	}

	@Override
	public int test3() {
		Criteria criteria = new Criteria("_id");
		criteria.is("62b10967bf47014238bc59c0");
		Query query = new Query(criteria);
		List<TestDTO> dtolist = template.findAll(TestDTO.class,"test");

		System.out.println("테스트"+dtolist.size());
		return 0;
	}

	@Override
	public int test4() {
		Criteria criteria = new Criteria("_id");
		//criteria.is("62b10967bf47014238bc59c0");
		Query query = new Query();

		Pageable pageable = PageRequest.of(1,10);

		query.with(pageable);

		List<TestDTO> dtolist = template.find(query,TestDTO.class);
		System.out.println("테스트"+dtolist);
		System.out.println("테스트"+dtolist.size());

		return 0;
	}

	@Override
	public int test5() {
//		Query query = new Query(Criteria.where("사건번호").regex("대구"));
//		Pageable pageable = PageRequest.of(1,10);
//
//		query.with(pageable);
//
//		List<TestDTO> dtolist = template.find(query,TestDTO.class);
//		System.out.println("테스트"+dtolist);
//		System.out.println("테스트"+dtolist.size());
//
//		List<String> names = template.findDistinct("소송유형", TestDTO.class, String.class);
//		System.out.println(names);
		Query query = new Query();
		//Criteria.where("사건번호").regex("대구")
		Pageable pageable = PageRequest.of(200,10);

		query.with(pageable);

		//List<TestDTO> dtolist = template.find(query,TestDTO.class);
		List<TestDTO> dtolist = template.findAll(TestDTO.class,"test");
		for (int i = 0; i < dtolist.size() ; i++){
			TestDTO dto = dtolist.get(i);
			ArrayList<Map<String,String>> map = dto.get본문();
			String id = dto.get사건번호();
			boolean has이유 = false;
			for (int j = 0; j <map.size();j++){
				Map<String,String> haha = map.get(j);

				System.out.println();
				String 이유 = haha.get("이유");
				if (이유 != null){
					System.out.println(이유);
				}
				if (이유 != null && (이유.contains("학교폭력") || 이유.contains("학교 폭력"))){
					System.out.println("끄아아아아아앙아각!!!!");
					has이유 = true;
				}
				System.out.println("");
			}
			if (has이유 == false){
				Criteria criteria = new Criteria("사건번호");
				criteria.is(id);
				Query query11 = new Query(criteria);
				template.remove(query11,"test");
			}

			List<TestDTO> dtolist2 = template.findAll(TestDTO.class,"test");

			System.out.println("다 끝낸 뒤 "+dtolist2.size());
			//System.out.println("와호"+map);
		}
		return 0;
	}
}