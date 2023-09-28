package com.example.inventory.Controllers;

import com.example.inventory.Data.*;
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

import java.util.Arrays;
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
        Ec2Instances instance = new Ec2Instances();
        when(ec2Services.addInstance(any(Ec2Instances.class))).thenReturn(instance);

        mockMvc.perform(post("/addInstance")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(instance)))
                .andExpect(status().isOk());

        verify(ec2Services, times(1)).addInstance(any(Ec2Instances.class));
    }

    @Test
    void addRegionTest() throws Exception {
        Regions region = new Regions();
        when(ec2Services.addRegion(any(Regions.class))).thenReturn(region);

        mockMvc.perform(post("/addRegion")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(region)))
                .andExpect(status().isOk());

        verify(ec2Services, times(1)).addRegion(any(Regions.class));
    }

    @Test
    void addVcpuCoreTest() throws Exception {
        VcpuCores vcpuCore = new VcpuCores();
        when(ec2Services.addVcpuCore(any(VcpuCores.class))).thenReturn(vcpuCore);

        mockMvc.perform(post("/addVcpuCore")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(vcpuCore)))
                .andExpect(status().isOk());

        verify(ec2Services, times(1)).addVcpuCore(any(VcpuCores.class));
    }

    @Test
    void addRegionInstancesTest() throws Exception {
        RegionInstances regionInstance = new RegionInstances();
        when(ec2Services.addRegionInstance(any(RegionInstances.class))).thenReturn(regionInstance);

        mockMvc.perform(post("/addRegionInstance")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(regionInstance)))
                .andExpect(status().isOk());

        verify(ec2Services, times(1)).addRegionInstance(any(RegionInstances.class));
    }

    @Test
    void addOsTest() throws Exception {
        OperatingSystems operatingSystem = new OperatingSystems();
        when(ec2Services.addOperatingSystem(any(OperatingSystems.class))).thenReturn(operatingSystem);

        mockMvc.perform(post("/addOperatingSystem")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(operatingSystem)))
                .andExpect(status().isOk());

        verify(ec2Services, times(1)).addOperatingSystem(any(OperatingSystems.class));
    }

    @Test
    void getRegionsTest() throws Exception {
        Regions region = new Regions();
        when(ec2Services.getRegions()).thenReturn(List.of(region));

        mockMvc.perform(get("/ec2-instance-explorer/regions"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(List.of(region))));

        verify(ec2Services, times(1)).getRegions();
    }

    @Test
    void getVcpuCoresTest() throws Exception {
        VcpuCores vcpuCore = new VcpuCores();
        when(ec2Services.getVcpuCores()).thenReturn(List.of(vcpuCore));

        mockMvc.perform(get("/ec2-instance-explorer/cpu"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(List.of(vcpuCore))));

        verify(ec2Services, times(1)).getVcpuCores();
    }

    @Test
    void getOperatingSystemsTest() throws Exception {
        OperatingSystems operatingSystem = new OperatingSystems();
        when(ec2Services.getOperatingSystems()).thenReturn(List.of(operatingSystem));

        mockMvc.perform(get("/ec2-instance-explorer/operating-systems"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(List.of(operatingSystem))));

        verify(ec2Services, times(1)).getOperatingSystems();
    }
}
