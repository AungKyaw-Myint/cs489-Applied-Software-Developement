package org.cs489.springsecurity.secured;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/management")
public class MemberController {

    @GetMapping
    public String getMember() {
        return "Member: secured end point";
    }

    @GetMapping("/admin-write")
    @PreAuthorize("hasAuthority('admin:write')")
    public String adminWrite() {
        return "Member: secured end point ony for admin write";
    }
}
