package com.faceye.feature.repository.mongo;

import com.faceye.feature.doc.Sequence;

public interface SequenceRepository  {
	
	public Sequence getSequenceByName(String name);
	
}
