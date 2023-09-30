package com.example.inventory.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.inventory.Data.RegionInstances;

@Repository
public interface RegionInstancesRepository extends JpaRepository< RegionInstances,Integer> {
    @Query(value = "SELECT ri.* FROM region_instances ri JOIN regions r ON ri.regions_id = r.region_id JOIN ec2_instances ei ON ri.instances_id = ei.instance_id JOIN vcpu_cores vc ON ei.vcpu_cores_id = vc.vcpu_core_id JOIN operating_systems os ON ei.operating_systems_id = os.operating_system_id WHERE (r.region_long_name IS NULL OR r.region_long_name = :regionName ) AND (vc.core_count IS NULL OR vc.core_count = :coreCount ) AND (os.operating_system_name IS NULL OR os.operating_system_name = :osName )", nativeQuery = true)
    List<RegionInstances> findByQuery(@Param("osName")String osName, @Param("regionName")String regionName, @Param("coreCount")Integer coreCount);
}
