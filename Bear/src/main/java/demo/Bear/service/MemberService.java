package demo.Bear.service;

import java.util.List;
import demo.Bear.model.*;


public interface MemberService {
	Member saveMember(Member Member);
    
    void delMemberById(String sid);
       
    Member findOneById(String sid);
    
    Member queryByName(String name);
    
    List<Member> findAll();
    
}
