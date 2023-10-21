package org.jugnicaragua.demos.demojakarta10jsf.domain;

public class TaskNotFoundException extends RuntimeException {

	public TaskNotFoundException(Long postId) {
		super(String.format("post id:%s not found!", postId));
	}

}
