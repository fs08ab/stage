package com.ssit.stage.biz.controller;

import com.alibaba.fastjson.JSONObject;
import com.ssit.stage.biz.bean.po.ActivityPO;
import com.ssit.stage.biz.bean.po.PartyBranchPO;
import com.ssit.stage.biz.bean.po.PartyMemberPO;
import com.ssit.stage.biz.bean.po.StagePO;
import com.ssit.stage.biz.bean.qo.ActivityQO;
import com.ssit.stage.biz.bean.qo.PartyBranchQO;
import com.ssit.stage.biz.bean.qo.PartyMemberQO;
import com.ssit.stage.biz.bean.qo.StageQO;
import com.ssit.stage.biz.bean.vo.BuildingVO;
import com.ssit.stage.biz.bean.vo.DictionaryVO;
import com.ssit.stage.biz.bean.vo.PartyBranchVO;
import com.ssit.stage.biz.bean.vo.PartyMemberVO;
import com.ssit.stage.biz.service.StageManageService;
import com.ssit.stage.common.constant.ConstantKey;
import com.ssit.stage.common.constant.StandardResult;
import com.ssit.stage.common.exception.BaseException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 驿站信息编辑接口，主要用于后台
 *
 * @author Fs
 * @since 2017/4/5 9:28
 */
@RestController
@RequestMapping("/manage")
public class StageManageController {
    private static final Log LOGGER = LogFactory.getLog(StageManageController.class);

    private final StageManageService stageManageService;

    @Autowired
    public StageManageController(StageManageService stageManageService) {
        this.stageManageService = stageManageService;
    }

    @ResponseBody
    @RequestMapping("/create_stage")
    public String createStage(@RequestBody StagePO stage) {
        StandardResult standardResult;
        try {
            stageManageService.createStage(stage);
            standardResult = new StandardResult(StandardResult.ResultType.SUCCESS);
        } catch (Exception e) {
            BaseException exception = BaseException.boxException(e);
            standardResult = new StandardResult(exception);
            LOGGER.error(exception.getLogMessage(), e);
        }
        return JSONObject.toJSONString(standardResult);
    }

    @ResponseBody
    @RequestMapping("/modify_stage")
    public String modifyStage(@RequestBody StagePO stage) {
        StandardResult standardResult;
        try {
            stageManageService.modifyStage(stage);
            standardResult = new StandardResult(StandardResult.ResultType.SUCCESS);
        } catch (Exception e) {
            BaseException exception = BaseException.boxException(e);
            standardResult = new StandardResult(exception);
            LOGGER.error(exception.getLogMessage(), e);
        }
        return JSONObject.toJSONString(standardResult);
    }

    @ResponseBody
    @RequestMapping("/query_stages")
    public String queryStages(@RequestBody StageQO stage) {
        StandardResult standardResult;
        try {
            standardResult = new StandardResult(StandardResult.ResultType.SUCCESS);
            standardResult.setAttach(stageManageService.queryStages(stage));
        } catch (Exception e) {
            BaseException exception = BaseException.boxException(e);
            standardResult = new StandardResult(exception);
            LOGGER.error(exception.getLogMessage(), e);
        }
        return JSONObject.toJSONString(standardResult);
    }

    @ResponseBody
    @RequestMapping("/create_party_branch")
    public String createPartyBranch(@RequestBody PartyBranchPO partyBranch) {
        StandardResult standardResult;
        try {
            stageManageService.createPartyBranch(partyBranch);
            standardResult = new StandardResult(StandardResult.ResultType.SUCCESS);
        } catch (Exception e) {
            BaseException exception = BaseException.boxException(e);
            standardResult = new StandardResult(exception);
            LOGGER.error(exception.getLogMessage(), e);
        }
        return JSONObject.toJSONString(standardResult);
    }

    @ResponseBody
    @RequestMapping("/modify_party_branch")
    public String modifyPartyBranch(@RequestBody PartyBranchPO partyBranch) {
        StandardResult standardResult;
        try {
            stageManageService.modifyPartyBranch(partyBranch);
            standardResult = new StandardResult(StandardResult.ResultType.SUCCESS);
        } catch (Exception e) {
            BaseException exception = BaseException.boxException(e);
            standardResult = new StandardResult(exception);
            LOGGER.error(exception.getLogMessage(), e);
        }
        return JSONObject.toJSONString(standardResult);
    }

    @ResponseBody
    @RequestMapping("/query_party_branches")
    public String queryPartyBranches(@RequestBody PartyBranchQO partyBranch) {
        StandardResult standardResult;
        try {
            standardResult = new StandardResult(StandardResult.ResultType.SUCCESS);
            standardResult.putAttachAll(stageManageService.queryPartyBranches(partyBranch));
        } catch (Exception e) {
            BaseException exception = BaseException.boxException(e);
            standardResult = new StandardResult(exception);
            LOGGER.error(exception.getLogMessage(), e);
        }
        return JSONObject.toJSONString(standardResult);
    }

    @ResponseBody
    @RequestMapping("/create_party_member")
    public String createPartyMember(@RequestBody PartyMemberPO partyMember) {
        StandardResult standardResult;
        try {
            stageManageService.createPartyMember(partyMember);
            standardResult = new StandardResult(StandardResult.ResultType.SUCCESS);
        } catch (Exception e) {
            BaseException exception = BaseException.boxException(e);
            standardResult = new StandardResult(exception);
            LOGGER.error(exception.getLogMessage(), e);
        }
        return JSONObject.toJSONString(standardResult);
    }

    @ResponseBody
    @RequestMapping("/modify_party_member")
    public String modifyPartyMember(@RequestBody PartyMemberPO partyMember) {
        StandardResult standardResult;
        try {
            stageManageService.modifyPartyMember(partyMember);
            standardResult = new StandardResult(StandardResult.ResultType.SUCCESS);
        } catch (Exception e) {
            BaseException exception = BaseException.boxException(e);
            standardResult = new StandardResult(exception);
            LOGGER.error(exception.getLogMessage(), e);
        }
        return JSONObject.toJSONString(standardResult);
    }

    @ResponseBody
    @RequestMapping("/query_party_member")
    public String queryPartyMembers(@RequestBody PartyMemberQO partyMember) {
        StandardResult standardResult;
        try {
            standardResult = new StandardResult(StandardResult.ResultType.SUCCESS);
            standardResult.setAttach(stageManageService.queryPartyMembers(partyMember));
        } catch (Exception e) {
            BaseException exception = BaseException.boxException(e);
            standardResult = new StandardResult(exception);
            LOGGER.error(exception.getLogMessage(), e);
        }
        return JSONObject.toJSONString(standardResult);
    }

    @ResponseBody
    @RequestMapping("/query_pm_count/{party_branch_id}")
    public String queryPMCount(@PathVariable("party_branch_id") int partyBranchId) {
        StandardResult standardResult;
        try {
            standardResult = new StandardResult(StandardResult.ResultType.SUCCESS);
            standardResult.putAttach(ConstantKey.RESULT_ROWS, stageManageService.queryPMCount(partyBranchId));
        } catch (Exception e) {
            BaseException exception = BaseException.boxException(e);
            standardResult = new StandardResult(exception);
            LOGGER.error(exception.getLogMessage(), e);
        }
        return JSONObject.toJSONString(standardResult);
    }

    @ResponseBody
    @RequestMapping("/create_activity")
    public String createActivity(@RequestBody ActivityPO activity) {
        StandardResult standardResult;
        try {
            stageManageService.createActivity(activity);
            standardResult = new StandardResult(StandardResult.ResultType.SUCCESS);
        } catch (Exception e) {
            BaseException exception = BaseException.boxException(e);
            standardResult = new StandardResult(exception);
            LOGGER.error(exception.getLogMessage(), e);
        }
        return JSONObject.toJSONString(standardResult);
    }

    @ResponseBody
    @RequestMapping("/modify_activity")
    public String modifyActivity(@RequestBody ActivityPO activity) {
        StandardResult standardResult;
        try {
            stageManageService.modifyActivity(activity);
            standardResult = new StandardResult(StandardResult.ResultType.SUCCESS);
        } catch (Exception e) {
            BaseException exception = BaseException.boxException(e);
            standardResult = new StandardResult(exception);
            LOGGER.error(exception.getLogMessage(), e);
        }
        return JSONObject.toJSONString(standardResult);
    }

    @ResponseBody
    @RequestMapping("/query_activities")
    public String queryActivities(@RequestBody ActivityQO activity) {
        StandardResult standardResult;
        try {
            standardResult = new StandardResult(StandardResult.ResultType.SUCCESS);
            standardResult.setAttach(stageManageService.queryActivities(activity));
        } catch (Exception e) {
            BaseException exception = BaseException.boxException(e);
            standardResult = new StandardResult(exception);
            LOGGER.error(exception.getLogMessage(), e);
        }
        return JSONObject.toJSONString(standardResult);
    }

    @ResponseBody
    @RequestMapping("/examine_activity")
    public String examineActivity(@RequestBody ActivityPO activity) {
        StandardResult standardResult;
        try {
            stageManageService.examineActivity(activity);
            standardResult = new StandardResult(StandardResult.ResultType.SUCCESS);
        } catch (Exception e) {
            BaseException exception = BaseException.boxException(e);
            standardResult = new StandardResult(exception);
            LOGGER.error(exception.getLogMessage(), e);
        }
        return JSONObject.toJSONString(standardResult);
    }

    @ResponseBody
    @RequestMapping("/query_options")
    public String queryOptions(@RequestParam String categoryCode) {
        StandardResult standardResult;
        try {
            List<DictionaryVO> options = stageManageService.queryOptions(categoryCode);
            standardResult = new StandardResult(StandardResult.ResultType.SUCCESS);
            standardResult.setAttach(options);
        } catch (Exception e) {
            BaseException exception = BaseException.boxException(e);
            standardResult = new StandardResult(exception);
            LOGGER.error(exception.getLogMessage(), e);
        }
        return JSONObject.toJSONString(standardResult);
    }

    @ResponseBody
    @RequestMapping("/query_building_options")
    public String queryBuildingOptions() {
        StandardResult standardResult;
        try {
            List<BuildingVO> buildingList = stageManageService.queryBuildingOptions();
            standardResult = new StandardResult(StandardResult.ResultType.SUCCESS);
            standardResult.setAttach(buildingList);
        } catch (Exception e) {
            BaseException exception = BaseException.boxException(e);
            standardResult = new StandardResult(exception);
            LOGGER.error(exception.getLogMessage(), e);
        }
        return JSONObject.toJSONString(standardResult);
    }

    @ResponseBody
    @RequestMapping("/query_party_branch_options")
    public String queryPartyBranchOptions() {
        StandardResult standardResult;
        try {
            List<PartyBranchVO> partyBranchList = stageManageService.queryPartyBranchOptions();
            standardResult = new StandardResult(StandardResult.ResultType.SUCCESS);
            standardResult.setAttach(partyBranchList);
        } catch (Exception e) {
            BaseException exception = BaseException.boxException(e);
            standardResult = new StandardResult(exception);
            LOGGER.error(exception.getLogMessage(), e);
        }
        return JSONObject.toJSONString(standardResult);
    }

    @ResponseBody
    @RequestMapping("/query_party_member_options")
    public String queryPartyMemberOptions() {
        StandardResult standardResult;
        try {
            List<PartyMemberVO> partyMemberList = stageManageService.queryPartyMemberOptions();
            standardResult = new StandardResult(StandardResult.ResultType.SUCCESS);
            standardResult.setAttach(partyMemberList);
        } catch (Exception e) {
            BaseException exception = BaseException.boxException(e);
            standardResult = new StandardResult(exception);
            LOGGER.error(exception.getLogMessage(), e);
        }
        return JSONObject.toJSONString(standardResult);
    }
}
