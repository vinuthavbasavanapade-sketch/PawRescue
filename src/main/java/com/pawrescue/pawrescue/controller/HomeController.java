
package com.pawrescue.pawrescue.controller;

import com.pawrescue.pawrescue.entity.AnimalReport;
import com.pawrescue.pawrescue.entity.Volunteer;
import com.pawrescue.pawrescue.entity.AdoptionRequest;

import com.pawrescue.pawrescue.repository.AnimalReportRepository;
import com.pawrescue.pawrescue.repository.VolunteerRepository;
import com.pawrescue.pawrescue.repository.AdoptionRequestRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private final AnimalReportRepository animalReportRepository;
    private final VolunteerRepository volunteerRepository;
    private final AdoptionRequestRepository adoptionRequestRepository;

    public HomeController(
            AnimalReportRepository animalReportRepository,
            VolunteerRepository volunteerRepository,
            AdoptionRequestRepository adoptionRequestRepository) {

        this.animalReportRepository = animalReportRepository;
        this.volunteerRepository = volunteerRepository;
        this.adoptionRequestRepository = adoptionRequestRepository;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    // Animal Report
    @GetMapping("/report")
    public String reportPage() {
        return "report";
    }

    @PostMapping("/report")
    public String submitReport(
            @RequestParam String animalType,
            @RequestParam String location,
            @RequestParam String description) {

        AnimalReport report = new AnimalReport();
        report.setAnimalType(animalType);
        report.setLocation(location);
        report.setDescription(description);
        report.setStatus("Pending");

        animalReportRepository.save(report);

        return "redirect:/report";
    }

    // Volunteer Registration
    @GetMapping("/volunteer")
    public String volunteerPage() {
        return "volunteer";
    }

    @PostMapping("/volunteer")
    public String registerVolunteer(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String phone,
            @RequestParam String location) {

        Volunteer volunteer = new Volunteer();
        volunteer.setName(name);
        volunteer.setEmail(email);
        volunteer.setPhone(phone);
        volunteer.setLocation(location);
        volunteer.setRole("VOLUNTEER");
        volunteer.setAvailable(true);

        volunteerRepository.save(volunteer);

        return "redirect:/volunteer";
    }

    // Adoption Request
    @GetMapping("/adoption")
    public String adoptionPage() {
        return "adoption";
    }

    @PostMapping("/adoption")
    public String submitAdoption(
            @RequestParam String adopterName,
            @RequestParam String email,
            @RequestParam String animalName) {

        AdoptionRequest request = new AdoptionRequest();
        request.setAdopterName(adopterName);
        request.setEmail(email);
        request.setAnimalName(animalName);
        request.setStatus("Pending");

        adoptionRequestRepository.save(request);

        return "redirect:/adoption";
    }

    // Check Adoption Status
    @GetMapping("/check-adoption")
    public String checkAdoptionPage() {
        return "check-adoption";
    }

    @PostMapping("/check-adoption")
    public String checkAdoption(
            @RequestParam String email,
            Model model) {

        model.addAttribute("requests",
                adoptionRequestRepository.findByEmail(email));

        return "check-adoption";
    }

    // Admin Dashboard
    @GetMapping("/admin")
    public String adminPage(Model model) {

        model.addAttribute("reports", animalReportRepository.findAll());
        model.addAttribute("volunteers", volunteerRepository.findAll());
        model.addAttribute("adoptionRequests", adoptionRequestRepository.findAll());

        return "admin";
    }

    // Update Animal Report Status
    @PostMapping("/admin/update-status")
    public String updateReportStatus(
            @RequestParam Long reportId,
            @RequestParam String status) {

        AnimalReport report = animalReportRepository
                .findById(reportId).orElse(null);

        if (report != null) {
            report.setStatus(status);
            animalReportRepository.save(report);
        }

        return "redirect:/admin";
    }

    // Update Adoption Request Status
    @PostMapping("/admin/adoption/update-status")
    public String updateAdoptionStatus(
            @RequestParam int adoptionId,
            @RequestParam String status) {

        AdoptionRequest request = adoptionRequestRepository
                .findById(adoptionId).orElse(null);

        if (request != null &&
                (status.equals("Pending") ||
                 status.equals("Approved") ||
                 status.equals("Rejected"))) {

            request.setStatus(status);
            adoptionRequestRepository.save(request);
        }

        return "redirect:/admin";
    }
}
