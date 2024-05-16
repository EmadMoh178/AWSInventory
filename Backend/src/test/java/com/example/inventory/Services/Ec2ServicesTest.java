package com.example.inventory.Services;

import com.example.inventory.Models.*;
import com.example.inventory.Repositories.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class Ec2ServicesTest {

    @Mock
    Ec2Repository ec2Repository;

    @Mock
    RegionRepository regionsRepository;

    @Mock
    VcpuCoresRepository vcpuCoresRepository;

    @Mock
    RegionInstancesRepository regionInstancesRepository;

    @Mock
    OperatingSystemsRepository operatingSystemsRepository;

    @InjectMocks
    Ec2Services ec2Services;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addInstanceTest() {
        // Given
        Ec2Instance instance = new Ec2Instance();
        when(ec2Repository.save(any(Ec2Instance.class))).thenReturn(instance);

        // When
        Ec2Instance savedInstance = ec2Services.addInstance(instance);

        // Then
        assertEquals(instance, savedInstance);
        verify(ec2Repository, times(1)).save(instance);
    }

    @Test
    void addOperatingSystemTest() {
        // Given
        OperatingSystem os = new OperatingSystem();
        when(operatingSystemsRepository.save(any(OperatingSystem.class))).thenReturn(os);

        // When
        OperatingSystem savedOs = ec2Services.addOperatingSystem(os);

        // Then
        assertEquals(os, savedOs);
        verify(operatingSystemsRepository, times(1)).save(os);
    }

    @Test
    void addRegionTest() {
        // Given
        Region region = new Region();
        when(regionsRepository.save(any(Region.class))).thenReturn(region);

        // When
        Region savedRegion = ec2Services.addRegion(region);

        // Then
        assertEquals(region, savedRegion);
        verify(regionsRepository, times(1)).save(region);
    }

    @Test
    void addVcpuCoreTest() {
        // Given
        VcpuCore vcpu = new VcpuCore();
        when(vcpuCoresRepository.save(any(VcpuCore.class))).thenReturn(vcpu);

        // When
        VcpuCore savedVcpu = ec2Services.addVcpuCore(vcpu);

        // Then
        assertEquals(vcpu, savedVcpu);
        verify(vcpuCoresRepository, times(1)).save(vcpu);
    }

    @Test
    void addRegionInstanceTest() {
        // Given
        RegionInstance regionInstance = new RegionInstance();
        when(regionInstancesRepository.save(any(RegionInstance.class))).thenReturn(regionInstance);

        // When
        RegionInstance savedRegionInstance = ec2Services.addRegionInstance(regionInstance);

        // Then
        assertEquals(regionInstance, savedRegionInstance);
        verify(regionInstancesRepository, times(1)).save(regionInstance);
    }

    @Test
    void getRegionsTest() {
        // Given
        List<Region> regionsList = Collections.singletonList(new Region());
        when(regionsRepository.findAll()).thenReturn(regionsList);

        // When
        List<Region> fetchedRegions = ec2Services.getRegions();

        // Then
        assertEquals(1, fetchedRegions.size());
        verify(regionsRepository, times(1)).findAll();
    }

    @Test
    void getVcpuCoresTest() {
        // Given
        List<VcpuCore> vcpuList = Collections.singletonList(new VcpuCore());
        when(vcpuCoresRepository.findAll()).thenReturn(vcpuList);

        // When
        List<VcpuCore> fetchedVcpus = ec2Services.getVcpuCores();

        // Then
        assertEquals(1, fetchedVcpus.size());
        verify(vcpuCoresRepository, times(1)).findAll();
    }

    @Test
    void getOperatingSystemsTest() {
        // Given
        List<OperatingSystem> osList = Collections.singletonList(new OperatingSystem());
        when(operatingSystemsRepository.findAll()).thenReturn(osList);

        // When
        List<OperatingSystem> fetchedOsList = ec2Services.getOperatingSystems();

        // Then
        assertEquals(1, fetchedOsList.size());
        verify(operatingSystemsRepository, times(1)).findAll();
    }
    @Test
    public void testSearchFound() {
        // Given
        List<RegionInstance> regionInstancesList = Collections.singletonList(new RegionInstance());
        when(regionInstancesRepository.findRegionInstances("Middle East", "Linux", 15))
                .thenReturn(regionInstancesList);

        // When
        List<RegionInstance> fetchedRegionInstancesList= ec2Services.search("Middle East", "Linux", 15);
        
        // Then
        assertEquals(1,fetchedRegionInstancesList.size());
    }

    @Test
    public void testSearchNotFound() {
        // Given
        List<RegionInstance> regionInstancesList = Collections.singletonList(new RegionInstance());
        when(regionInstancesRepository.findRegionInstances("Middle East", "Linux", 15))
                .thenReturn(regionInstancesList);

        // When
        List<RegionInstance> fetchedRegionInstancesList= ec2Services.search("Europe", "Linux", 15);
        
        // Then
        assertEquals(0,fetchedRegionInstancesList.size());
    }
}
