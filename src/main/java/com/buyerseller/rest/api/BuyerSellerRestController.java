package com.buyerseller.rest.api;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.buyerseller.exception.InvalidUserException;
import com.buyerseller.exception.ServiceException;
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
		if (StringUtils.isEmpty(userId))
			throw new InvalidUserException();

		Long projectId = buyerSellerService.addProject(projectModel, Long.valueOf(userId));
		
		HttpHeaders header = new HttpHeaders();
        header.set("Location", generateHostname(request)+"/svc/buyerseller/v1/project/"+projectId);
        return new ResponseEntity<>(header, HttpStatus.CREATED);

	}
    
    
    @RequestMapping(value = "/project", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE , produces = "application/json")
    public ResponseEntity<?> updateProject(@RequestBody ProjectModel projectModel,HttpServletRequest request)
	{

		String userId = request.getHeader("User_Id");
		if (StringUtils.isEmpty(userId))
			throw new InvalidUserException();

		Long projectId = buyerSellerService.addProject(projectModel, Long.valueOf(userId));
		
		HttpHeaders header = new HttpHeaders();
        header.set("Location", generateHostname(request)+"/svc/buyerseller/v1/project/"+projectId);
        return new ResponseEntity<>(header, HttpStatus.CREATED);

	}

    @RequestMapping(value = "/project", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE ,produces = "application/json")
    public ResponseEntity<?> getProjectList(HttpServletRequest request,@RequestParam Optional<Integer>  limit)
	{
		String userId = request.getHeader("User_Id");
		if (StringUtils.isEmpty(userId))
			throw new InvalidUserException();

		List<ProjectModel> list = buyerSellerService.getProjectList(limit);

		HttpHeaders header = new HttpHeaders();
		header.set("Total-Count", String.valueOf(list.size()));
		return new ResponseEntity<>(list, header, HttpStatus.OK);

	}

    @RequestMapping(value = "/project/{projectId}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE , produces = "application/json")
    public ResponseEntity<?> getProjectDetails(@PathVariable String projectId,HttpServletRequest request)
	{
		String userId = request.getHeader("User_Id");
		if (StringUtils.isEmpty(userId))
			throw new InvalidUserException();

		ProjectModel projectModel = buyerSellerService.getProjectDetails(Long.valueOf(projectId));

		HttpHeaders header = new HttpHeaders();
		return new ResponseEntity<>(projectModel, header, HttpStatus.OK);

	}

    @RequestMapping(value = "/project/{projectId}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE ,produces = "application/json")
    public ResponseEntity<?> deleteProject(@PathVariable String projectId,HttpServletRequest request)
	{
		String userId = request.getHeader("User_Id");
		if (StringUtils.isEmpty(userId))
			throw new InvalidUserException();

		buyerSellerService.deleteProject(projectId);
		return new ResponseEntity<>(HttpStatus.OK);

	}

    @RequestMapping(value = "/bid/{projectId}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE , produces = "application/json")
    public ResponseEntity<?> bidForProject(@PathVariable String projectId,@RequestBody BidModel bidModel,HttpServletRequest request)
	{
		String userId = request.getHeader("User_Id");
		if (StringUtils.isEmpty(userId))
			throw new InvalidUserException();

		buyerSellerService.bidForProject(Long.valueOf(projectId), bidModel, Long.valueOf(userId));

		return new ResponseEntity<>(HttpStatus.OK);

	}

    @RequestMapping(value = "/bid/{projectId}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE , produces = "application/json")
    public ResponseEntity<?> getBidList(@PathVariable String projectId,HttpServletRequest request)
	{
		String userId = request.getHeader("User_Id");
		if (StringUtils.isEmpty(userId))
			throw new InvalidUserException();

		List<BidModel> list = buyerSellerService.getBidList(Long.valueOf(projectId));

		HttpHeaders header = new HttpHeaders();
		header.set("Total-Count", String.valueOf(list.size()));
		return new ResponseEntity<>(list, header, HttpStatus.OK);

	}

    @RequestMapping(value = "/bid/{bidId}", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE , produces = "application/json")
    public ResponseEntity<?> withdrawBid(@PathVariable String bidId,HttpServletRequest request)
    {
	String userId = request.getHeader("User_Id");
	if(StringUtils.isEmpty(userId)) throw new InvalidUserException();

        throw new ServiceException("NOT IMPLEMENTED");

    }
    
    
	/**
	 * @param context
	 *            HttpServletRequest
	 * @return String
	 */
	private  String generateHostname(HttpServletRequest context) {
		return "http://" + context.getServerName()+":"+context.getServerPort();
	}
}
