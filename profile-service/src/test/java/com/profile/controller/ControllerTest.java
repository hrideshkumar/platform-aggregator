package com.profile.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.profile.dto.SearchProfile;
import com.profile.service.ProfileService;

@WebMvcTest
public class ControllerTest {

	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProfileService service;

    @InjectMocks
    private Controller controller;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testGetAllProfileList() throws Exception {
        SearchProfile profile1 = new SearchProfile(1, "hridesh", "kumar");
        SearchProfile profile2 = new SearchProfile(2, "john", "doe");
        List<SearchProfile> profiles = Arrays.asList(profile1, profile2);

        when(service.getAllProfiles("facebook")).thenReturn(profiles);

        mockMvc.perform(get("/profile/facebook"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName").value("hridesh"))
                .andExpect(jsonPath("$[1].firstName").value("john"));
    }
}
