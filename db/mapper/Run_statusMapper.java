package db.mapper;

import java.util.List;

import db.model.Run_status;

public interface Run_statusMapper {
	int insertRun_status(Run_status run_status);
	int deleteRun_status(Run_status run_status);
	List<Run_status> selectRun_status(Run_status run_status);

}
