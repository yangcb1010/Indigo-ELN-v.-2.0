package com.epam.indigoeln.web.rest.dto;

import com.epam.indigoeln.core.model.Project;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * DTO for Project
 */
@JsonTypeName("Project")
public class ProjectDTO extends BasicDTO {

    private List<String> tags;
    private String keywords;
    private String references;
    private String description;
    private List<NotebookDTO> notebooks;
    private Set<String> fileIds;

    public ProjectDTO() {
        super();
    }

    public ProjectDTO(Project project) {

        super(project);

        this.description = project.getDescription();
        this.fileIds = project.getFileIds();
        this.keywords = project.getKeywords();
        this.notebooks = project.getNotebooks() != null ?
                project.getNotebooks().stream().map(NotebookDTO::new).collect(Collectors.toList()) : new ArrayList<>();
        this.references = project.getReferences();
        this.tags = project.getTags();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<String> getFileIds() {
        return fileIds;
    }

    public void setFileIds(Set<String> fileIds) {
        this.fileIds = fileIds;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public List<NotebookDTO> getNotebooks() {
        return notebooks;
    }

    public void setNotebooks(List<NotebookDTO> notebooks) {
        this.notebooks = notebooks;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "ProjectDTO{} " + super.toString();
    }
}