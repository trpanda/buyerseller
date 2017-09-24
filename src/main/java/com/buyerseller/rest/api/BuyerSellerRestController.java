package com.buyerseller.rest.api;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.buyerseller.exception.InvalidUserException;
import com.buyerseller.rest.api.model.BidModel;
import com.buyerseller.rest.api.model.ProjectModel;
import com.buyerseller.service.BuyerSellerService;

@RestController
@RequestMapping(value =
{
        "/v1", "/svc/buyerseller/v1"
})
public class BuyerSellerRestController
{
    
    @Autowired
    private BuyerSellerService buyerSellerService;

    @RequestMapping(value = "/project", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE , produces = "application/json")
    public ResponseEntity<?> addProject(@RequestBody ProjectModel projectModel,HttpServletRequest request)
    {
	
	String userId = request.getHeader("User_Id");
	if(StringUtils.isEmpty(userId)) throw new InvalidUserException();

        return null;

    }

    @RequestMapping(value = "/project", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE ,produces = "application/json")
    public ResponseEntity<?> getProjectList(HttpServletRequest request,@RequestParam int limit)
    {
	String userId = request.getHeader("User_Id");
	if(StringUtils.isEmpty(userId)) throw new InvalidUserException();


        return null;

    }

    @RequestMapping(value = "/project/{projectId}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE , produces = "application/json")
    public ResponseEntity<?> getProjectDetails(@PathVariable String projectId,HttpServletRequest request)
    {
	String userId = request.getHeader("User_Id");
	if(StringUtils.isEmpty(userId)) throw new InvalidUserException();


        return null;

    }

    @RequestMapping(value = "/project/{projectId}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE ,produces = "application/json")
    public ResponseEntity<?> deleteProject(@PathVariable String projectId,HttpServletRequest request)
    {
	String userId = request.getHeader("User_Id");
	if(StringUtils.isEmpty(userId)) throw new InvalidUserException();

        return null;

    }

    @RequestMapping(value = "/bid/{projectId}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE , produces = "application/json")
    public ResponseEntity<?> bidForProject(@PathVariable String projectId,@RequestBody BidModel bidModel,HttpServletRequest request)
    {
	String userId = request.getHeader("User_Id");
	if(StringUtils.isEmpty(userId)) throw new InvalidUserException();

        return null;

    }

    @RequestMapping(value = "/bid/{projectid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE , produces = "application/json")
    public ResponseEntity<?> getBidList(@PathVariable String projectId,HttpServletRequest request)
    {
	String userId = request.getHeader("User_Id");
	if(StringUtils.isEmpty(userId)) throw new InvalidUserException();

        return null;

    }

    @RequestMapping(value = "/bid/{bidId}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE , produces = "application/json")
    public ResponseEntity<?> withdrawBid(@PathVariable String bidId,HttpServletRequest request)
    {
	String userId = request.getHeader("User_Id");
	if(StringUtils.isEmpty(userId)) throw new InvalidUserException();

        return null;

    }
}
