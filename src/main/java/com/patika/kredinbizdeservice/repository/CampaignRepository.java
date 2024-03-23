package com.patika.kredinbizdeservice.repository;

import com.patika.kredinbizdeservice.enums.SectorType;
import com.patika.kredinbizdeservice.model.Campaign;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CampaignRepository {

    private final List<Campaign> campaignList = new ArrayList<>();

    public void save(Campaign campaign) {
        campaignList.add(campaign);
    }

    public List<Campaign> getAll() {
        return campaignList.stream()
                .sorted(Comparator.comparing(Campaign::getCreateDate).reversed())
                .collect(Collectors.toList());
    }

    @PostConstruct
    private void createRandomCampaign() {
        Campaign campaign1 = new Campaign("Yaz İndirimi", "Yaz sezonunda geçerli indirimler", LocalDate.of(2024, 5, 30), LocalDate.of(2023, 9, 6), LocalDate.of(2024, 3, 10), SectorType.TRAVELS);
        Campaign campaign2 = new Campaign("Emlak Kredisi Kampanyası", "Ev almak isteyenlere özel faiz oranları", LocalDate.of(2024, 5, 31), LocalDate.of(2024, 1, 25), LocalDate.of(2024, 1, 15), SectorType.FINANCE);
        Campaign campaign3 = new Campaign("Yılbaşı Özel", "Yılbaşına özel süpermarketlerde kaçırılmayacak fırsatlar", LocalDate.of(2024, 5, 25), LocalDate.of(2024, 2, 1), LocalDate.of(2024, 11, 15), SectorType.MARKET);
        campaignList.add(campaign1);
        campaignList.add(campaign2);
        campaignList.add(campaign3);
    }
}
