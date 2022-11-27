package demo.Bear.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.Bear.model.Member;
import demo.Bear.model.MemberRepository;
import demo.Bear.service.MemberService;


@RestController
@RequestMapping(value = "/member")
public class memberController {
	
	 @Autowired
	 private MemberService memberService;
	 
	 @RequestMapping(value = "/add", method = RequestMethod.POST)
	    public String addMember( Member member) {
		 member = memberService.saveMember(member);
	        return "新增成功，返回用戶Sid為："+member.getSid();
	    }
	 @RequestMapping(value = "/query", method = RequestMethod.GET)
	    public List<Member> queryMember() {		 		 
	        return memberService.findAll();
	    }
	 @RequestMapping(value = "/delete", method = RequestMethod.POST)
	    public String deleteMember(@RequestParam("sid") String sid) {		 
	         memberService.delMemberById(sid);
	         return "刪除完畢";
	    }
	 @RequestMapping(value = "/update", method = RequestMethod.POST)
	    public String updateMember(@RequestParam("sid") String sid, Member mm) {		 
	         Member member = memberService.findOneById(sid);
	         member.setSname(mm.getSname());
	         member.setPassword(mm.getPassword());
	         member.setEmail(mm.getEmail());
	         member.setCell(mm.getCell());
	         memberService.saveMember(member);
	         return "更新完畢";
	    }
	 
}
