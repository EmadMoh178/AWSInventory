package com.example.inventory.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventory.Models.Ec2Instance;
import com.example.inventory.Models.OperatingSystem;
import com.example.inventory.Models.RegionInstance;
import com.example.inventory.Models.Region;
import com.example.inventory.Models.VcpuCore;
import com.example.inventory.Services.Ec2Services;

@RestController
public class Ec2Controller {
    @Autowired
    Ec2Services ec2Services;

    @PostMapping("/instances")
    public Ec2Instance addInstance(@RequestBody Ec2Instance ec2Instances){
        return ec2Services.addInstance(ec2Instances);
    }

    @PostMapping("/regions")
    public Region addRegion(@RequestBody Region region){
        return ec2Services.addRegion(region);
    }

    @PostMapping("/vcpu-cores")
    public VcpuCore addVcpuCore(@RequestBody VcpuCore vcpuCore){
        return ec2Services.addVcpuCore(vcpuCore);
    }

    @PostMapping("/region-instances")
    public RegionInstance addRegionInstances(@RequestBody RegionInstance regionInstance){
        return ec2Services.addRegionInstance(regionInstance);
    }

    @PostMapping("/operating-systems")
    public OperatingSystem addOs(@RequestBody OperatingSystem operatingSystem){
        return ec2Services.addOperatingSystem(operatingSystem);
    }

    @GetMapping("/regions")
    public List <Region> getRegions (){
        return ec2Services.getRegions();
    }

    @GetMapping("/vcpu-cores")
    public List <VcpuCore> getVcpuCores(){
        return ec2Services.getVcpuCores();
    }

    @GetMapping("/operating-systems")
    public List <OperatingSystem> getOperatingSystems(){
        return ec2Services.getOperatingSystems();
    }

    @PostMapping("/search")
    public List<RegionInstance> search(@RequestParam("regionName") String regionName, @RequestParam("osName") String osName, @RequestParam("cpu") Integer cpu){
        return ec2Services.search(regionName,osName,cpu);
    }
}
