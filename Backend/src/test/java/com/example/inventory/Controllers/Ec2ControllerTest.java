package com.example.inventory.Controllers;

import com.example.inventory.Models.*;
import com.example.inventory.Services.Ec2Services;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class Ec2ControllerTest {

    private MockMvc mockMvc;

    @Mock
    private Ec2Services ec2Services;

    @InjectMocks
    private Ec2Controller ec2Controller;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(ec2Controller).build();
    }

    @Test
    void addInstanceTest() throws Exception {
        Ec2Instance instance = new Ec2Instance();
        when(ec2Services.addInstance(any(Ec2Instance.class))).thenReturn(instance);

        mockMvc.perform(post("/instances")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(instance)))
                .andExpect(status().isOk());

        verify(ec2Services, times(1)).addInstance(any(Ec2Instance.class));
    }

    @Test
    void addRegionTest() throws Exception {
        Region region = new Region();
        when(ec2Services.addRegion(any(Region.class))).thenReturn(region);

        mockMvc.perform(post("/regions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(region)))
                .andExpect(status().isOk());

        verify(ec2Services, times(1)).addRegion(any(Region.class));
    }

    @Test
    void addVcpuCoreTest() throws Exception {
        VcpuCore vcpuCore = new VcpuCore();
        when(ec2Services.addVcpuCore(any(VcpuCore.class))).thenReturn(vcpuCore);

        mockMvc.perform(post("/vcpu-cores")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(vcpuCore)))
                .andExpect(status().isOk());

        verify(ec2Services, times(1)).addVcpuCore(any(VcpuCore.class));
    }

    @Test
    void addRegionInstancesTest() throws Exception {
        RegionInstance regionInstance = new RegionInstance();
        when(ec2Services.addRegionInstance(any(RegionInstance.class))).thenReturn(regionInstance);

        mockMvc.perform(post("/region-instances")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(regionInstance)))
                .andExpect(status().isOk());

        verify(ec2Services, times(1)).addRegionInstance(any(RegionInstance.class));
    }

    @Test
    void addOsTest() throws Exception {
        OperatingSystem operatingSystem = new OperatingSystem();
        when(ec2Services.addOperatingSystem(any(OperatingSystem.class))).thenReturn(operatingSystem);

        mockMvc.perform(post("/operating-systems")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(operatingSystem)))
                .andExpect(status().isOk());

        verify(ec2Services, times(1)).addOperatingSystem(any(OperatingSystem.class));
    }

    @Test
    void getRegionsTest() throws Exception {
        Region region = new Region();
        when(ec2Services.getRegions()).thenReturn(List.of(region));

        mockMvc.perform(get("/regions"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(List.of(region))));

        verify(ec2Services, times(1)).getRegions();
    }

    @Test
    void getVcpuCoresTest() throws Exception {
        VcpuCore vcpuCore = new VcpuCore();
        when(ec2Services.getVcpuCores()).thenReturn(List.of(vcpuCore));

        mockMvc.perform(get("/vcpu-cores"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(List.of(vcpuCore))));

        verify(ec2Services, times(1)).getVcpuCores();
    }

    @Test
    void getOperatingSystemsTest() throws Exception {
        OperatingSystem operatingSystem = new OperatingSystem();
        when(ec2Services.getOperatingSystems()).thenReturn(List.of(operatingSystem));

        mockMvc.perform(get("/operating-systems"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(List.of(operatingSystem))));

        verify(ec2Services, times(1)).getOperatingSystems();
    }
}
