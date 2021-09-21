package com.alkemy.ong.web;

import com.alkemy.ong.database.entities.MemberEntity;
import com.alkemy.ong.database.jparepositories.MemberJPARepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static java.util.Collections.singletonList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberJPARepository repository;

    public ObjectWriter mapperConfig(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        return ow;
    }

    @Test
    public void getMembers() throws Exception {
        when(repository.findAll()).thenReturn(singletonList(buildMemberEntity()));
        mockMvc.perform(get("/members"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"name\":\"Agustina\",\"facebookUrl\"" +
                        ":\"facebook.com\"," + "\"instagramUrl\":\"instagram.com\",\"linkedinUrl\":\"linkedin.com\"," +
                        "\"image\":\"image1.png\",\"description\":\"description\"}]"));
    }

    @Test
    public void deleteMember() throws Exception {
        MemberEntity member = buildMemberEntity();
        when(repository.findById(1L)).thenReturn(java.util.Optional.of(new MemberEntity()));
        mockMvc.perform(delete("/members/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void updateMember() throws Exception {
        when(repository.findById(1L)).thenReturn(Optional.of(new MemberEntity()));
        mockMvc.perform(put("/members/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapperConfig().writeValueAsString(buildMemberEntity())))
                .andExpect(status().isOk());
    }

    @Test
    public void createMember() throws Exception {
        mockMvc.perform(post("/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapperConfig().writeValueAsString(buildMemberEntity())))
                .andExpect(status().isCreated());
    }

    private MemberEntity buildMemberEntity() {
        MemberEntity member = new MemberEntity();

        member.setId(1L);
        member.setName("Agustina");
        member.setFacebookUrl("facebook.com");
        member.setInstagramUrl("instagram.com");
        member.setLinkedinUrl("linkedin.com");
        member.setImage("image1.png");
        member.setDescription("description");

        return member;
    }
}