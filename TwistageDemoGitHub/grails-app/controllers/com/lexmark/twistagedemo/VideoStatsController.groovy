package com.lexmark.twistagedemo

import com.videoprovider.api.VideoApi
import com.videoprovider.model.VideoStats
import com.videoprovider.model.VideoStatsByVideo
import groovy.json.JsonSlurper
import org.json.JSONArray
import org.json.JSONObject

class VideoStatsController
{
	def index()
	{
		VideoApi api = VideoApi.forAccount ("http://svc.psft.co",'richmedia-solutions','d66d21f5e8002')
		def options = new HashMap()
		options.put 'group', 'video'
		options.put 'direction', 'down'
		
		def allStats = api.getDeliveryStats(options)[0]
		
		def plays = allStats.getPlays()
		def hits = allStats.getHits()
		def downloads = allStats.getDownloads()
		def bytes = allStats.getBytesTransferred()
		
		def videosJson = new JsonSlurper().parseText(api.getAllVideos(new HashMap(), 'json'))
		def statsMap = [:]
		def hitList = []
		def playList = []
		
		videosJson.videos.each
		{
			def vid = it.video_id
			def vidStats = api.getDeliveryStatsForVideo(vid, new HashMap())[0]
			def p = vidStats.getPlays()
			def h = vidStats.getHits()
			def d = vidStats.getDownloads()
			def b = vidStats.getBytesTransferred()
			
			statsMap.put vid, [title: it.title, plays: p, hits: h, downloads: d, bytes: b]
			hitList << [it.title, h as int]
			playList << [it.title, p as int]
			
			print it.title
			print "vid: $vid"
			print "plays: $p"
			print "downloads: $d"
			print "bytes: $b"
			print "hits: $h"
			print "--------------"
		}
		
		print hitList
		render view: 'index', model: [stats: statsMap, hits: hitList, plays: playList]
	}
}
