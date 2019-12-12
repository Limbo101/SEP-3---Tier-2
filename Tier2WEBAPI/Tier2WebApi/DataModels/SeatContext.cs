using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Tier2WebApi.DataModels
{
    public class SeatContext : DbContext
    {
        public SeatContext(DbContextOptions<SeatContext> options) : base(options)
        {

        }

        public DbSet<Seat> seats { get; set; }

    }
}
