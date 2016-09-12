package com.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "projectteam")
@XmlSeeAlso(ProjectMember.class)
public class ProjectTeam {
    private String projectName;
    private final List<ProjectMember> members = new ArrayList<>();

    @XmlElement(name = "member")
    public List getMembers() {
        return this.members;
    }

    public void addMember(ProjectMember member) {
        this.members.add(member);
    }

    @XmlElement(name = "projectname")
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
