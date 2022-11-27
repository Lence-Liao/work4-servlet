package demo.Bear.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.Bear.model.Member;
import demo.Bear.model.MemberRepository;


@Service
public class MemberServiceImpl implements MemberService{
	@Autowired 
	private MemberRepository memberRepository;	
	
	@Override
	public Member saveMember(Member member) {		
        return memberRepository.save(member);
	}

	@Override
	public void delMemberById(String sid) {
		memberRepository.deleteById(sid);		
	}
	

	@Override
	public Member findOneById(String sid) {
		
		return memberRepository.findById(sid).orElse(null);
	}

	@Override
	public Member queryByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> findAll() {
		return memberRepository.findAll();		
	}
	
}
