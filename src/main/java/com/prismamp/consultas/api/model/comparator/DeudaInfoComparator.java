package com.prismamp.consultas.api.model.comparator;

import java.util.Comparator;

import com.prismamp.consultas.api.model.dto.DeudaInfoDTO;

public class DeudaInfoComparator implements Comparator<DeudaInfoDTO> {
	
	public int compare(DeudaInfoDTO obj1, DeudaInfoDTO obj2) {
		int ret = 0;

		if (obj1 instanceof DeudaInfoDTO && obj2 instanceof DeudaInfoDTO) {
			
			DeudaInfoDTO di1 = (DeudaInfoDTO) obj1;
			DeudaInfoDTO di2 = (DeudaInfoDTO) obj2;

			/*if ((StringUtils.isNotEmpty(di1.getError())) && (StringUtils.isEmpty(di2.getError()))) {
				ret = 1;
			} else if ((StringUtils.isEmpty(di1.getError())) && (StringUtils.isNotEmpty(di2.getError()))) {
				ret = -1;
			} else*/ if (di1.getVencimiento() != null && di2.getVencimiento() == null) {
				ret = -1;
			} else if (di1.getVencimiento() == null && di2.getVencimiento() != null) {
				ret = 1;
			} else if (di1.getVencimiento() != null && di2.getVencimiento() != null) {
				if (di1.getVencimiento().after(di2.getVencimiento())) {
					ret = 1;
				} else if (di1.getVencimiento().before(di2.getVencimiento())) {
					ret = -1;
				}
			}
		}

		return ret;
	}
}
