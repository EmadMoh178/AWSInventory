package com.example.inventory.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventory.Models.Ec2Instance;
import com.example.inventory.Models.OperatingSystem;
import com.example.inventory.Models.RegionInstance;
import com.example.inventory.Models.Region;
import com.example.inventory.Models.VcpuCore;
import com.example.inventory.Repositories.Ec2Repository;
import com.example.inventory.Repositories.OperatingSystemsRepository;
import com.example.inventory.Repositories.RegionInstancesRepository;
import com.example.inventory.Repositories.RegionRepository;
import com.example.inventory.Repositories.VcpuCoresRepository;


@Service
public class Ec2Services {
    @Autowired
    Ec2Repository ec2Repository;

    @Autowired
    RegionRepository regionsRepository;

    @Autowired
    VcpuCoresRepository vcpuCoresRepository;
    @Autowired
    RegionInstancesRepository regionInstancesRepository;

    @Autowired
    OperatingSystemsRepository operatingSystemsRepository;
    public Ec2Instance addInstance(Ec2Instance ec2Instances){
        return ec2Repository.save(ec2Instances);
    }

    public OperatingSystem addOperatingSystem(OperatingSystem operatingSystem){
        return operatingSystemsRepository.save(operatingSystem);
    }

    public Region addRegion(Region region){
        return regionsRepository.save(region);
    }
    public VcpuCore addVcpuCore(VcpuCore vcpuCore){
        return vcpuCoresRepository.save(vcpuCore);
    }
    public RegionInstance addRegionInstance(RegionInstance regionInstance){
        return regionInstancesRepository.save(regionInstance);
    }

    public List <Region> getRegions (){
        return regionsRepository.findAll();
    }

    public List <VcpuCore> getVcpuCores(){
        return vcpuCoresRepository.findAll();
    }
    public List <OperatingSystem> getOperatingSystems(){
        return operatingSystemsRepository.findAll();
    }

    public List<RegionInstance> search(String regionName, String osName, Integer cpu){
        if(regionName == "") regionName = null;
        if(osName == "") osName = null;
        return regionInstancesRepository.findRegionInstances(regionName,osName,cpu);
    }
}
