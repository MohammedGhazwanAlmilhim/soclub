package com.example.soclub.service

import android.health.connect.datatypes.ExerciseRoute
import com.example.soclub.models.Activity
import com.google.firebase.firestore.ListenerRegistration
import com.example.soclub.models.CreateActivity
import com.example.soclub.models.EditActivity
import android.location.Location

interface ActivityService {
    suspend fun getActivityById(category: String, activityId: String): Activity?
    suspend fun createActivity(category: String, activity: CreateActivity)
    suspend fun getActivities(category: String): List<Activity>
    suspend fun getCategories(): List<String>
    suspend fun getAllActivitiesByCreator(creatorId: String): List<EditActivity>
    suspend fun updateActivity(category: String, newCategory: String, activityId: String, updatedActivity: CreateActivity)
    suspend fun getAllActivities(): List<Activity>
    suspend fun getActivitiesGroupedByCategory(): Map<String, List<Activity>>
    suspend fun deleteActivity(category: String, activityId: String)
    fun listenForActivities(onUpdate: (List<Activity>) -> Unit): ListenerRegistration
    fun listenForNearestActivities(userLocation: Location, maxDistance: Float, onUpdate: (List<Activity>) -> Unit): ListenerRegistration
    suspend fun getRegisteredUsersForActivity(activityId: String): List<String>
}
