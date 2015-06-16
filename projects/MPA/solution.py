from pprint import pprint as pp
import csv

def readmiit(l_of_adperiods):
	""""given a list of admission periods, this function returns a list of 
	 admission periods prior to when there was a readmission within 30 days"""

	relapseperiods = []
	i = 0
	for period in l_of_adperiods:
		if i == 0:
			og_start,end = period
			i += 1
		else:
			start,_ = period
			relapse = start - end
			if relapse <= 30:
				relapseperiods.append((og_start, end))
			og_start,end = period
	return relapseperiods


def create_patient_dict(admissions):
	"""creates a dictionary of patients and their various admission periods"""

	patientdict = {}
	for admission in admissions:
		y = admission.strip()
		y = y.split(',')
		ids = y[0]
		periods = [(int(y[2]), int(y[3]))]
		if ids in patientdict.keys():
			patientdict[ids].extend(periods)
		else:
			patientdict[ids] = periods
	return patientdict

def find_relapsed_patients(patientdict):
	"""given the dictionary of parents & admission periods this function checks for parents with 30 day
	readmitts and uses their info to create a dictionary of readmitted patients and their admission periods
	prior to the relapse"""

	new_dict = {}
	for patientids in patientdict.keys():
		relapse_periods = readmiit(patientdict[patientids])
		if len(relapse_periods) != 0:
			new_dict[patientids] = relapse_periods
	return new_dict

def create_drugusedict(drug_use):
	"""given the pharmacy info this function creates a dictionary of patients, their drug use and the periods
	they used the drugs for"""

	pdrugdict = {}
	for data in drug_use:		
		y = data.strip()
		y = y.split(',')
		ids = y[0]
		drug = y[1]
		du_periods = [(int(y[2]), int(y[3]))]
		if ids in pdrugdict.keys():
			drugdictionaries = pdrugdict[ids]
			druglist = [drugtionary for drugtionary in drugdictionaries if drug in drugtionary.keys()]  #creates a list of the dictionary of drugs with their usage periods
			if len(druglist) != 0:
				drugtionary = druglist[0]
				drugtionary[drug].extend(du_periods)
			else: 
				pdrugdict[ids].append({drug:du_periods})
		else:
			pdrugdict[ids] = [{drug:du_periods}]

	return(pdrugdict)

def was_drug_used(admission_periods, drug_usage_periods):
	"""given the admission periods and drug periods, this function checks to see
	if a drug was used during an admission period"""

	total_ad_days = []
	total_usage_days = []
	for admissions in admission_periods:
		start, end = admissions
		ad_days = list(range(start, end + 1))
		total_ad_days.extend(ad_days)
	
	for period in drug_usage_periods:
		start, end = period
		usage_days = list(range(start, end + 1))
		total_usage_days.extend(usage_days)
	
	for day in total_ad_days:
		if day in total_usage_days:
			return True
		else:
			continue

def find_relapse_causing_drugs(relapse_info, drug_info):
	"""given the readmission info and the drug usage info, this function creates a dictionary of
	drugs used and the number of patients who used them"""
	drugIDdict = {}
	for patients, adperiods in relapse_info.items():
		for drugstion in drug_info[patients]:
			for drug, drugperiod in drugstion.items():
				result = was_drug_used(adperiods, drugperiod)
				if result == True and drug not in drugIDdict.keys():
					drugIDdict[drug] = 1
				elif result == True and drug in drugIDdict.keys():
					drugIDdict[drug] += 1
			
	return(drugIDdict)


if __name__ == "__main__":
	with open('admissions.csv') as admissionfile:
		skip = admissionfile.readline()										#skips the header line
		admissions = admissionfile.readlines()								#gets all the useful data in the file
		patientdict = create_patient_dict(admissions)						#creates a dictionary of patients and their admissions
		relapsedpatientdict = find_relapsed_patients(patientdict)			#goes through the patients dictionary then creates a dictionary of patienst who relapsed within 30 days
	
	with open('pharmacy.csv') as pharmacyfile:
		skip = pharmacyfile.readline()										#skips the header line
		drug_use = pharmacyfile.readlines()									#gets all the useful data in the file
		patient_druguse = create_drugusedict(drug_use)						#creates a dictionary of patients and their drug use
	
	repatient_drugdict  = find_relapse_causing_drugs(relapsedpatientdict, patient_druguse) #a dictionary of the drugs used and number of patient who relapsed 
	data = [["drugID","number_of_patients"]]								#first line of the csv file
	for key, value in repatient_drugdict.items():							#makes a list of list of the data to be converted to csv
		a = [key, value]
		data.append(a)
	
	with open('solution.csv', 'w') as solutionfile:
		a = csv.writer(solutionfile)
		a.writerows(data)
	






