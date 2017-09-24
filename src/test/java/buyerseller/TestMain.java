package buyerseller;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;

import com.buyerseller.common.JsonMapper;
import com.buyerseller.rest.api.model.BidModel;
import com.buyerseller.rest.api.model.ProjectModel;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class TestMain {
	
    public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException{
    	
    	JsonMapper jsonMapper = new JsonMapper();
    	
    	BidModel bidModel = new BidModel();
    	bidModel.setBidId(5l);
    	bidModel.setBidValue(new BigDecimal(10.0));
    	bidModel.setProjectId(1l);
    	
    	String bidMoldeJson = jsonMapper.objectToJson(bidModel);
    	
    	ProjectModel projectModel = new ProjectModel();
    	
    	long timenowPlusone = System.currentTimeMillis()+60*10000;
    	long now = System.currentTimeMillis();
    	System.out.println(now);
    	Timestamp expiryDateTime = new Timestamp(timenowPlusone);
    	
    	projectModel.setExpiryDateTime(expiryDateTime);
    	projectModel.setProjectName("prjectOne");
    	projectModel.setSellerId(1l);
    	
    	String projectMoldeJson = jsonMapper.objectToJson(projectModel);
    	
    	
    	System.out.println(bidMoldeJson);
    	
    	System.out.println(projectMoldeJson);
    	
    }

}
