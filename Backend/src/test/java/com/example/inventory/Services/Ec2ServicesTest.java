package com.example.inventory.Services;

import com.example.inventory.Data.*;
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
    RegionsRepository regionsRepository;

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
        Ec2Instances instance = new Ec2Instances();
        when(ec2Repository.save(any(Ec2Instances.class))).thenReturn(instance);

        // When
        Ec2Instances savedInstance = ec2Services.addInstance(instance);

        // Then
        assertEquals(instance, savedInstance);
        verify(ec2Repository, times(1)).save(instance);
    }

    @Test
    void addOperatingSystemTest() {
        // Given
        OperatingSystems os = new OperatingSystems();
        when(operatingSystemsRepository.save(any(OperatingSystems.class))).thenReturn(os);

        // When
        OperatingSystems savedOs = ec2Services.addOperatingSystem(os);

        // Then
        assertEquals(os, savedOs);
        verify(operatingSystemsRepository, times(1)).save(os);
    }

    @Test
    void addRegionTest() {
        // Given
        Regions region = new Regions();
        when(regionsRepository.save(any(Regions.class))).thenReturn(region);

        // When
        Regions savedRegion = ec2Services.addRegion(region);

        // Then
        assertEquals(region, savedRegion);
        verify(regionsRepository, times(1)).save(region);
    }

    @Test
    void addVcpuCoreTest() {
        // Given
        VcpuCores vcpu = new VcpuCores();
        when(vcpuCoresRepository.save(any(VcpuCores.class))).thenReturn(vcpu);

        // When
        VcpuCores savedVcpu = ec2Services.addVcpuCore(vcpu);

        // Then
        assertEquals(vcpu, savedVcpu);
        verify(vcpuCoresRepository, times(1)).save(vcpu);
    }

    @Test
    void addRegionInstanceTest() {
        // Given
        RegionInstances regionInstance = new RegionInstances();
        when(regionInstancesRepository.save(any(RegionInstances.class))).thenReturn(regionInstance);

        // When
        RegionInstances savedRegionInstance = ec2Services.addRegionInstance(regionInstance);

        // Then
        assertEquals(regionInstance, savedRegionInstance);
        verify(regionInstancesRepository, times(1)).save(regionInstance);
    }

    @Test
    void getRegionsTest() {
        // Given
        List<Regions> regionsList = Collections.singletonList(new Regions());
        when(regionsRepository.findAll()).thenReturn(regionsList);

        // When
        List<Regions> fetchedRegions = ec2Services.getRegions();

        // Then
        assertEquals(1, fetchedRegions.size());
        verify(regionsRepository, times(1)).findAll();
    }

    @Test
    void getVcpuCoresTest() {
        // Given
        List<VcpuCores> vcpuList = Collections.singletonList(new VcpuCores());
        when(vcpuCoresRepository.findAll()).thenReturn(vcpuList);

        // When
        List<VcpuCores> fetchedVcpus = ec2Services.getVcpuCores();

        // Then
        assertEquals(1, fetchedVcpus.size());
        verify(vcpuCoresRepository, times(1)).findAll();
    }

    @Test
    void getOperatingSystemsTest() {
        // Given
        List<OperatingSystems> osList = Collections.singletonList(new OperatingSystems());
        when(operatingSystemsRepository.findAll()).thenReturn(osList);

        // When
        List<OperatingSystems> fetchedOsList = ec2Services.getOperatingSystems();

        // Then
        assertEquals(1, fetchedOsList.size());
        verify(operatingSystemsRepository, times(1)).findAll();
    }
}
