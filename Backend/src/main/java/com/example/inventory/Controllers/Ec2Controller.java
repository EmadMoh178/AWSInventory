package com.example.inventory.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventory.Data.Ec2Instances;
import com.example.inventory.Data.OperatingSystems;
import com.example.inventory.Data.RegionInstances;
import com.example.inventory.Data.Regions;
import com.example.inventory.Data.VcpuCores;
import com.example.inventory.Services.Ec2Services;

@RestController
public class Ec2Controller {
    @Autowired
    Ec2Services ec2Services;

    @PostMapping("/addInstance")
    public Ec2Instances addInstance(@RequestBody Ec2Instances ec2Instances){
        return ec2Services.addInstance(ec2Instances);
    }
    @PostMapping("/addRegion")
    public Regions addRegion(@RequestBody Regions region){
        return ec2Services.addRegion(region);
    }

    @PostMapping("/addVcpuCore")
    public VcpuCores addVcpuCore(@RequestBody VcpuCores vcpuCore){
        return ec2Services.addVcpuCore(vcpuCore);
    }

    @PostMapping("/addRegionInstance")
    public RegionInstances addRegionInstances(@RequestBody RegionInstances regionInstance){
        return ec2Services.addRegionInstance(regionInstance);
    }

    @PostMapping("/addOperatingSystem")
    public OperatingSystems addOs(@RequestBody OperatingSystems operatingSystem){
        return ec2Services.addOperatingSystem(operatingSystem);
    }

    @GetMapping("/ec2-instance-explorer/regions")
    public List < Regions > getRegions (){
        return ec2Services.getRegions();
    }

    @GetMapping("/ec2-instance-explorer/cpu")
    public List <VcpuCores> getVcpuCores(){
        return ec2Services.getVcpuCores();
    }

    @GetMapping("/ec2-instance-explorer/operating-systems")
    public List <OperatingSystems> getOperatingSystems(){
        return ec2Services.getOperatingSystems();
    }

    @PostMapping("/ec2-instance-explorer/search")
    public List<RegionInstances> search(@RequestParam("regionName") String regionName, @RequestParam("osName") String osName, @RequestParam("cpu") Integer cpu){
        
        return ec2Services.search(regionName,osName,cpu);
    }
}
