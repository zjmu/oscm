package edu.jmu.oscm.mapper;

import org.mapstruct.Mapper;

import java.math.BigInteger;

@Mapper
public interface ReportMapper {

    ReportMapper selectReport(BigInteger id);
}
