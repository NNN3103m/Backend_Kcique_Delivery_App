package hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.repositories

import hn.edu.ujcv.pdm_2021_ii_p3_proyecto3.backend.models.ItemModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface ItemRepository : JpaRepository<ItemModel, Long>