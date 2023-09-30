package com.example.inventory.Data;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@Entity
@Table(name = "vcpu_cores")
public class VcpuCores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int vcpuCoreId;
    int coreCount;
}
//SELECT ri.* FROM region_instances ri JOIN regions r ON ri.region_id = r.region_id JOIN ec2_instances ei ON ri.instance_id = ei.instance_id JOIN vcpu_cores vc ON ei.vcpu_core_id = vc.vcpu_core_id JOIN operating_systems os ON ei.operating_system_id = os.operating_system_id WHERE (r.region_name IS NULL OR r.region_name = 'Middle East') AND (vc.core_count IS NULL OR vc.core_count = 12) AND (os.operating_system_name IS NULL OR os.operating_system_name;
//SELECT * FROM region_instances r, ec2_instances l WHERE ( -1 = -1 OR r.region_id = -1 ) AND ( 2 = -1 OR l.vcpu_core_id = 2 ) AND ( 1 = -1 OR l.operating_system_id = 1 )   