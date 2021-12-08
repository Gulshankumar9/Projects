#!/usr/bin/env python
# coding: utf-8

# In[1]:


from pytrends.request import TrendReq
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import matplotlib
from IPython.display import Image
# Who is in space right now?
import requests
r = requests.get(url='http://api.open-notify.org/astros.json')
r.json()


# In[2]:


Image(filename='satsig_explanation.gif', width='60%')


# In[90]:


r = requests.get(url='http://api.open-notify.org/iss-now.json')
space_station_location = (r.json())
print(space_station_location)

space_station_location['iss_position']['latitude']
space_station_location['iss_position']['longitude']
space_station_location['timestamp']


# In[91]:


# let's plot the ISS current location
# you will need to pip install Basemap - https://matplotlib.org/basemap/users/installing.html
from mpl_toolkits.basemap import Basemap
import os
os.environ['PROJ_LIB'] = r'C:\Users\Gulshan\anaconda\pkgs\proj-7.2.0-h3e70539_0\Library\share'

# Set the dimension of the figure
plt.figure(figsize=(16, 8))

# Make the background map
m=Basemap(llcrnrlon=-180, llcrnrlat=-65,urcrnrlon=180,urcrnrlat=80)
m.drawmapboundary(fill_color='#A6CAE0', linewidth=0)
m.fillcontinents(color='grey', alpha=0.3)
m.drawcoastlines(linewidth=0.1, color="white")

m.scatter(float(space_station_location['iss_position']['longitude']), 
          float(space_station_location['iss_position']['latitude']), 
          s=500, alpha=0.4,color='blue')

 
plt.title('International Space Station Location' , fontsize=30)


# In[92]:


# load historical data
iss_flight_record = pd.read_csv('ISS_location_20210318155202.csv')
iss_flight_record.head()


# In[93]:


iss_flight_record.shape


# In[94]:


from datetime import datetime
date_time = [datetime.fromtimestamp(dt) for dt in iss_flight_record['timestamp']]
date_time
# add teh date_time to a new column in our data frame iss_flight_record
iss_flight_record['date'] = date_time
iss_flight_record.head()
# add an plot size from oldest to newest
iss_flight_record['index'] = range(1,len(iss_flight_record)+1)
iss_flight_record.head()


# In[95]:


# you will need to pip install Basemap - https://matplotlib.org/basemap/users/installing.html
from mpl_toolkits.basemap import Basemap

# Set the dimension of the figure
plt.figure(figsize=(16, 8))

# Make the background map
m=Basemap(llcrnrlon=-180, llcrnrlat=-65,urcrnrlon=180,urcrnrlat=80)
m.drawmapboundary(fill_color='#A6CAE0', linewidth=0)
m.fillcontinents(color='grey', alpha=0.3)
m.drawcoastlines(linewidth=0.1, color="white")

 
 
m.scatter(iss_flight_record['longitude'], 
          iss_flight_record['latitude'], 
          s=iss_flight_record['index'] , alpha=0.4,color='blue')

 
#plt.title('International Space Station Location' , fontsize=30) 


# In[134]:


# each dot represents one minute - can we predict where it will be in the next 10 minutes?
tmp_df = iss_flight_record.tail(10)
tmp_df


# In[135]:


plt.plot(tmp_df['longitude'],tmp_df['latitude'])
plt.grid()

#//last20 mins record  of iss plotted 


# In[136]:


from scipy import stats
slope, intercept, r_value, p_value, std_err = stats.linregress(
    x = tmp_df['longitude'],
    y = tmp_df['latitude'])


print('intercept: ', intercept)
print('slope: ', slope)


# In[147]:


# predict longitude 1 periods out
predicted_latitude = np.ceil(slope *10 + intercept)

print('Next predicted point:', predicted_latitude)


# In[148]:


fig, ax = plt.subplots(figsize=(10, 6))

plt.plot(tmp_df['longitude'],
    tmp_df['latitude'])

plt.suptitle('Future Location of the ISS')
plt.xlabel('Longitude')
plt.ylabel('Latitude')
plt.grid()

plt.scatter([10], [predicted_latitude], color='red')


# In[161]:


x = tmp_df['longitude']
y = tmp_df['latitude']

poly_regression = np.poly1d(np.polyfit(x, y, 3))

predicted_latitude =  poly_regression(20)

print('Next predicted point:', predicted_latitude)


# In[162]:


fig, ax = plt.subplots(figsize=(10, 6))

plt.plot(tmp_df['longitude'],
    tmp_df['latitude'])

plt.suptitle('Future Location of the ISS')
plt.xlabel('Longitude')
plt.ylabel('Latitude')
plt.grid()

plt.scatter((20), [predicted_latitude], color='red')


# In[13]:


import datetime
date_to_print = datetime.datetime.now().strftime("%Y%m%d%H%M%S")
date_to_print


# In[14]:


import time
starttime=time.time()
space_station_data = []
while True: 
    r = requests.get(url='http://api.open-notify.org/iss-now.json')
    space_station_location = (r.json())
    print(space_station_location)

    space_station_data.append([space_station_location['timestamp'],
                            space_station_location['iss_position']['latitude'],
                            space_station_location['iss_position']['longitude']
                            ])

    # dump copy to file
    tmp_space_station_data_df = pd.DataFrame(space_station_data, columns=['timestamp','latitude', 'longitude',])
    tmp_space_station_data_df.to_csv('ISS_location_' + date_to_print + '.csv', index=None)

    # safety break
    if len(space_station_data) > 18000:
        break

    # let it sleep 60 seconds
    # https://stackoverflow.com/questions/474528/what-is-the-best-way-to-repeatedly-execute-a-function-every-x-seconds-in-python
    time.sleep(60.0 - ((time.time() - starttime) % 30.0))


# In[ ]:


record_data = False
if record_data == True:
    


# In[ ]:





# In[ ]:





# In[ ]:




