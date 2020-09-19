package hu.frt;

import hu.frt.EducationalInstitution;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class InstitutionQueryController {
    @GetMapping("institution-query")
    public EducationalInstitution[] query(@RequestParam String omIdentificationNumber) {
        final String uri = "http://localhost:8083/institution-read?omIdentificationNumber="+omIdentificationNumber;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri,EducationalInstitution[].class);
    }
}
