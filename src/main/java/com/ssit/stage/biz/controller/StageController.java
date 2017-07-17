package com.ssit.stage.biz.controller;

import com.alibaba.fastjson.JSONObject;
import com.ssit.stage.biz.bean.vo.*;
import com.ssit.stage.biz.service.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class StageController {
	private final StageService stageService;

	@Autowired
	public StageController(StageService stageService) {
		this.stageService = stageService;
	}

	@ResponseBody
	@RequestMapping("/query_all_sections")
	public String querySections() {
		List<SectionVO> sectionVOs = stageService.querySections();
		return JSONObject.toJSONString(sectionVOs);
	}

	@ResponseBody
	@RequestMapping("/query_section/{section_id}")
	public String querySectionById(@PathVariable("section_id") int sectionId) {
		SectionVO sectionVO = stageService.querySectionById(sectionId);
		return JSONObject.toJSONString(sectionVO);
	}

	@ResponseBody
	@RequestMapping("/query_building/{building_id}")
	public String queryBuildingById(@PathVariable("building_id") String buildingId) {
		BuildingVO buildingVO = stageService.queryBuildingById(buildingId);
		return JSONObject.toJSONString(buildingVO);
	}

	@ResponseBody
	@RequestMapping("/query_party_branches/{building_id}")
	public String queryPartyBranches(@PathVariable("building_id") String buildingId) {
		List<PartyBranchVO> branchVOs = stageService.queryPartyBranches(buildingId);
		return JSONObject.toJSONString(branchVOs);
	}

	@ResponseBody
	@RequestMapping("/query_party_members/{party_branch_id}")
	public String queryPartyMembers(@PathVariable("party_branch_id") int partyBranchId) {
		List<PartyMemberVO> memberVOs = stageService.queryPartyMembers(partyBranchId);
		return JSONObject.toJSONString(memberVOs);
	}

	@ResponseBody
	@RequestMapping("/query_member_statistic/{building_id}")
	public String queryMemberStatistic(@PathVariable("building_id") String buildingId) {
		MemberStatisticVO memberStatistic = stageService.queryMemberStatistic(buildingId);
		return JSONObject.toJSONString(memberStatistic);
	}

	@ResponseBody
	@RequestMapping("/query_activities/{relation_id}")
	public String queryActivities(@RequestParam(name = "type", required = false) Integer type, @PathVariable("relation_id") int relationId) {
		List<ActivityVO> activityVOs = stageService.queryActivities(type, relationId);
		return JSONObject.toJSONString(activityVOs);
	}

	@ResponseBody
	@RequestMapping("/query_activity_rule")
	public String queryActivityRule() {
		List<ActivityRuleVO> activityRuleVOs = stageService.queryActivityRules();
		return JSONObject.toJSONString(activityRuleVOs);
	}

	@ResponseBody
	@RequestMapping("/query_activities_pm/{party_member_id}")
	public String queryActivitiesByPM(@PathVariable("party_member_id") int partyMemberId) {
		List<ActivityVO> activityVOs = stageService.queryActivitiesByPM(partyMemberId);
		return JSONObject.toJSONString(activityVOs);
	}

	@ResponseBody
	@RequestMapping("/query_pma_statistic/{party_member_id}")
	public String queryPMAStatistic(@PathVariable("party_member_id") int partyMemberId) {
		Map<String, Object> statistic = stageService.queryPMAStatistic(partyMemberId);
		return JSONObject.toJSONString(statistic);
	}
}