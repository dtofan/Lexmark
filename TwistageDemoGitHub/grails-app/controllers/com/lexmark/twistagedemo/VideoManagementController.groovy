package com.lexmark.twistagedemo

import com.videoprovider.model.Video
import com.videoprovider.model.VideoAsset
import com.videoprovider.model.VideoScreenshot
import com.videoprovider.api.VideoApi
import grails.plugins.springsecurity.Secured
import groovy.json.JsonSlurper

class VideoManagementController
{
	//@Secured(['ROLE_USER'])
	def index()
	{
		print "params: $params"
		
		def data = [:]
		VideoApi api = VideoApi.forAccount ("http://svc.psft.co",'richmedia-solutions','d66d21f5e8002')

		def videosJson = new JsonSlurper().parseText(api.getAllVideos(new HashMap(), 'json'))
		def videosMeta = [:]

		videosJson.videos.each
		{
			def vid = it.video_id
			def video = api.getVideoMetadata (vid)
			def asset = video.getSourceAsset()
			def horiz = asset.getResolutionHorizontal()
			def vert = asset.getResolutionVertical()
			def url = api.getDownloadUrl(vid)
			videosMeta.put(vid, [horiz: horiz, vert: vert])
		}

		render view: '/videoManagement/index', model:[videos: videosJson.videos, videosMeta: videosMeta]
	}
}
