package hu.frt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class InstitutionQueryController {
    @Value("${spring.profiles.active}")
    private String selectedProfile;

    @Value("${hostname}")
    private String hostname;

    @GetMapping("institution-query")
    public EducationalInstitution[] query(@RequestParam String omIdentificationNumber) {
        final String uri = "http://"+hostname+":8083/institution-read?omIdentificationNumber="+omIdentificationNumber;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri,EducationalInstitution[].class);
    }

    public String getSelectedProfile() {
        return selectedProfile;
    }

    public void setSelectedProfile(String selectedProfile) {
        this.selectedProfile = selectedProfile;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

}
