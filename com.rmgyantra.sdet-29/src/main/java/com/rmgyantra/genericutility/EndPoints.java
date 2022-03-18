package com.rmgyantra.genericutility;
/**
 * This interface will store all the endpoints
 * @author Admin
 *
 */
public interface EndPoints {

	String ADDPROJECT="/addProject";
	String GETALLPROJECTS="/projects";
	String GETSINGLEPROJECT="/projects/TY_PROJ_3802";
	String UPDATEPROJECT="/projects/{projectId}";
	String DELETEPROJECT="/projects/{projectId}";
}
