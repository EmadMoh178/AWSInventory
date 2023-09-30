package com.example.inventory.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.inventory.Data.Ec2Instances;
import com.example.inventory.Data.OperatingSystems;
import com.example.inventory.Data.RegionInstances;
import com.example.inventory.Data.Regions;
import com.example.inventory.Data.VcpuCores;
import com.example.inventory.Repositories.Ec2Repository;
import com.example.inventory.Repositories.OperatingSystemsRepository;
import com.example.inventory.Repositories.RegionInstancesRepository;
import com.example.inventory.Repositories.RegionsRepository;
import com.example.inventory.Repositories.VcpuCoresRepository;


@Service
public class Ec2Services {
    @Autowired
    Ec2Repository ec2Repository;

    @Autowired
    RegionsRepository regionsRepository;

    @Autowired
    VcpuCoresRepository vcpuCoresRepository;
    @Autowired
    RegionInstancesRepository regionInstancesRepository;

    @Autowired
    OperatingSystemsRepository operatingSystemsRepository;
    public Ec2Instances addInstance(Ec2Instances ec2Instances){
        return ec2Repository.save(ec2Instances);
    }

    public OperatingSystems addOperatingSystem(OperatingSystems operatingSystem){
        return operatingSystemsRepository.save(operatingSystem);
    }

    public Regions addRegion(Regions region){
        return regionsRepository.save(region);
    }
    public VcpuCores addVcpuCore(VcpuCores vcpuCore){
        return vcpuCoresRepository.save(vcpuCore);
    }
    public RegionInstances addRegionInstance(RegionInstances regionInstance){
        return regionInstancesRepository.save(regionInstance);
    }

    public List < Regions > getRegions (){
        return regionsRepository.findAll();
    }

    public List <VcpuCores> getVcpuCores(){
        return vcpuCoresRepository.findAll();
    }
    public List <OperatingSystems> getOperatingSystems(){
        return operatingSystemsRepository.findAll();
    }

    public List<RegionInstances> search(String regionName, String osName, Integer cpu){
        // OperatingSystems os =operatingSystemsRepository.findByOperatingSystemName(osName);
        // Integer os_id ;
        // if(!operatingSystemsRepository.existsByOperatingSystemName(osName)) os_id = -1;
        // else os_id =os.getOperatingSystemId();

        // Regions regions =regionsRepository.findByRegionLongName(regionName);
        // Integer region_id;
        // if(!regionsRepository.existsByRegionLongName(regionName)) region_id= -1;
        // else region_id=regions.getRegionId();

        // VcpuCores vcpuCores = vcpuCoresRepository.findByCoreCount(cpu);

        if(!vcpuCoresRepository.existsByCoreCount(cpu)) cpu= null;
        // System.out.println(os.getOsId());
        return regionInstancesRepository.findByQuery(regionName,osName,cpu);
    }
}
